package ade.dicoding.sub2.ui.favorites.movie


import ade.dicoding.sub2.R
import ade.dicoding.sub2.data.local.entity.MovieDetailEntity
import ade.dicoding.sub2.helper.SortUtils.NEWEST
import ade.dicoding.sub2.ui.detail.DetailActivity
import ade.dicoding.sub2.util.spinnerSorterAdapter
import ade.dicoding.sub2.util.visible
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
import kotlinx.android.synthetic.main.fragment_movie.*
import org.jetbrains.anko.sdk27.coroutines.onItemSelectedListener

/**
 * A simple [Fragment] subclass.
 */
class MovieFavFragment : Fragment(), MovieFavAdapter.CallbackAdapter {
    private lateinit var viewModel: MoviesFavViewModel
    private lateinit var adapter: MovieFavAdapter
    private var sorter = NEWEST
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        coll_lay.visible()
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(activity?.application)
            viewModel =
                ViewModelProviders.of(activity!!, factory).get(MoviesFavViewModel::class.java)
            initAdapter()
            setSearching()

            viewModel.setSorter(NEWEST)
            viewModel.movies.observe(this) { response ->
                if (response != null) {
                    when (response.status) {
                        Status.LOADING -> {
                        }
                        Status.ERROR -> {
                        }
                        Status.SUCCESS -> {
                            Log.e("response fav", "${response.data}")
                            response.apply {
                                if (!data.isNullOrEmpty()) {
                                    adapter.submitList(data)
                                    adapter.notifyDataSetChanged()
                                }

                            }
                        }
                    }
                }

            }

        }
    }

    private fun initAdapter() {
        sp_sort.adapter = spinnerSorterAdapter(context!!)
        sp_sort.onItemSelectedListener {
            onItemSelected { adapterView, view, i, l ->
                if (i > 0)
                    sorter = adapterView?.getItemAtPosition(i).toString()
                else sorter = NEWEST
                viewModel.setSorter(sorter)
            }
        }
        adapter = MovieFavAdapter(activity, this)
        rv_list.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = this@MovieFavFragment.adapter
        }

    }

    private fun setSearching() {
        et_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.isNullOrBlank())
                    viewModel.setSorter(sorter)
                else
                    viewModel.setSorter("$s")
            }
        })
    }

    override fun clicked(item: MovieDetailEntity?) {
        DetailActivity.startMovie(activity, item)

    }
}
