package ade.dicoding.sub2.ui.movies


import ade.dicoding.sub2.R
import ade.dicoding.sub2.data.local.entity.MoviesEntity
import ade.dicoding.sub2.data.model.Movies
import ade.dicoding.sub2.ui.detail.DetailActivity
import ade.dicoding.sub2.util.gone
import ade.dicoding.sub2.viewmodel.ViewModelFactory
import ade.dicoding.sub2.vo.Status
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.skydoves.baserecyclerviewadapter.RecyclerViewPaginator
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment(), Holder.Delegate {

    private lateinit var viewModel: MoviesViewModel
    private lateinit var adapter: MovieAdapter2
    private lateinit var paginator: RecyclerViewPaginator


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            coll_lay.gone()
            val factory = ViewModelFactory.getInstance(activity?.application)
            viewModel = ViewModelProviders.of(activity!!, factory).get(MoviesViewModel::class.java)
            initAdapter()
            setSearching()
            loadMore(1)
            viewModel.movies.observe(this) { response ->
                Log.e("response", "$response")
                if (response != null) {
                    when (response.status) {
                        Status.LOADING -> {

                        }
                        Status.ERROR -> {

                        }
                        Status.SUCCESS -> {
                            response.apply {
                                if (!data.isNullOrEmpty()) {
                                    adapter.addItems(data as ArrayList<MoviesEntity>)
                                }

                            }
                        }
                    }
                }
            }

            viewModel.movieSearch.observe(this) { apiResponse ->
                val movieList = mutableListOf<MoviesEntity>()
                (apiResponse.body as Movies).results?.forEach { re ->
                    Log.e("searchEntiti", re.toString())
                    re?.apply {
                        val moviesEntity =
                            MoviesEntity(
                                popularity,
                                posterPath,
                                1,
                                id,
                                backdropPath,
                                title,
                                overview,
                                releaseDate,
                                0
                            )
                        movieList.add(moviesEntity)
                    }
                }
                adapter.changeItems(movieList)
            }

        }
    }

    private fun loadMore(it: Int) {
        Log.e("page", it.toString())
        viewModel.setPage(it)
    }

    private fun setSearching() {
        et_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString().isBlank()) {
                    resetAdapter()
                } else viewModel.search(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
    }

    private fun resetAdapter() {
        adapter.clearAllSections()
        adapter.addSectionMovie()
        paginator.currentPage = 1
        paginator.resetCurrentPage()
    }


    private fun initAdapter() {
        adapter = MovieAdapter2(this)
        rv_list.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = this@MovieFragment.adapter
        }

        paginator = RecyclerViewPaginator(
            recyclerView = rv_list,
            onLast = { false },
            loadMore = { loadMore(it) },
            isLoading = { viewModel.getMovieValue()?.status == Status.LOADING }
        )
        paginator.currentPage = 1
    }

    override fun itemClick(movie: MoviesEntity) {
        DetailActivity.startMovie(activity, movie)
    }

    companion object {
        fun newInstance(): Fragment {
            return MovieFragment()
        }
    }
}
