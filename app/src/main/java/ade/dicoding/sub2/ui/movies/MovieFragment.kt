package ade.dicoding.sub2.ui.movies


import ade.dicoding.sub2.R
import ade.dicoding.sub2.data.model.Movies
import ade.dicoding.sub2.viewmodel.ViewModelFactory
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

class MovieFragment : Fragment() {

    private lateinit var viewModel: MoviesViewModel
    private lateinit var adapter: MovieAdapter
    private lateinit var movies: MutableList<Movies.Result>

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
            val factory = ViewModelFactory.getInstance(activity!!.application)
            viewModel = ViewModelProviders.of(activity!!, factory).get(MoviesViewModel::class.java)
            movies = mutableListOf()
            initAdapter()
            setSearching()
            viewModel.movies().observe(this) { response ->
                Log.e("result", response.toString())
                movies.clear()
                response?.apply {
                    if (!results.isNullOrEmpty()) {
                        movies.addAll(results as MutableList<Movies.Result>)
                    }
                }
                adapter.notifyDataSetChanged()

            }

        }
    }
    private fun setSearching() {
        et_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.filter.filter(s)
            }
        })
    }


    private fun initAdapter() {
        adapter = MovieAdapter(activity, movies)
        rv_list.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = this@MovieFragment.adapter
        }
    }

    companion object {
        fun newInstance(): Fragment {
            return MovieFragment()
        }
    }
}
