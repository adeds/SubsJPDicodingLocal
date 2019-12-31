package ade.dicoding.sub2.ui.detail

import ade.dicoding.sub2.R
import ade.dicoding.sub2.util.POSTER_PATH
import ade.dicoding.sub2.util.loadImageURL
import ade.dicoding.sub2.viewmodel.ViewModelFactory
import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*
import org.jetbrains.anko.startActivity

class DetailActivity : AppCompatActivity() {
    private val itemTitle by lazy { intent.getStringExtra(EXTRA_ITEM) }
    private val isMovie by lazy { intent.getBooleanExtra(EXTRA_IS_MOVIE, false) }
    private val idContent by lazy { intent.getIntExtra(EXTRA_ID_CONTENT, 0) }
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = itemTitle
        }
        Log.e("detail", "$itemTitle $isMovie $idContent")
        val factory = ViewModelFactory.getInstance(application)
        viewModel = ViewModelProviders.of(this, factory).get(DetailViewModel::class.java)
        if (isMovie) {
            getMovieDetail()
        } else getTvDetail()

    }

    private fun getTvDetail() {
        viewModel.movie(idContent).observe(this) { response ->
            response?.apply {
                dtl_img.loadImageURL(POSTER_PATH + posterPath)
                dtl_title.text = originalTitle
                dtl_date.text = releaseDate
                var genre = ""
                genres?.forEach {
                    genre = it?.name + " "
                }
                dtl_crew.text = genre
                val desc = "Status: $status \nPopularity: $popularity \n$tagline"
                dtl_desc.text = desc
                dtl_overview.text = overview
                dtl_review.text = homepage

            }
        }
    }

    private fun getMovieDetail() {
        viewModel.tv(idContent).observe(this) { response ->
            response?.apply {
                dtl_img.loadImageURL(POSTER_PATH + posterPath)
                dtl_title.text = originalName
                dtl_date.text = "$firstAirDate - $lastAirDate"
                var genre = ""
                genres?.forEach {
                    genre = it?.name + " "
                }

                var creator = ""
                createdBy?.forEach {
                    creator = it?.name + " "
                }
                dtl_crew.text = genre
                val desc = "Status: $status \nPopularity: $popularity \n$creator"
                dtl_desc.text = desc
                dtl_overview.text = overview
                dtl_review.text = homepage
            }
        }
    }


    companion object {
        const val EXTRA_ITEM = "EXTRA_ITEM"
        const val EXTRA_ID_CONTENT = "EXTRA_ID_CONTENT"
        const val EXTRA_IS_MOVIE = "EXTRA_IS_MOVIE"
        fun start(
            activity: Activity?,
            item: String,
            movie: Boolean,
            id: Int?
        ) {
            activity?.startActivity<DetailActivity>(
                EXTRA_ITEM to item,
                EXTRA_ID_CONTENT to id,
                EXTRA_IS_MOVIE to movie
            )
        }
    }

}
