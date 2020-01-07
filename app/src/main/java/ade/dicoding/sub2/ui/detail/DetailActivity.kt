package ade.dicoding.sub2.ui.detail

import ade.dicoding.sub2.R
import ade.dicoding.sub2.data.local.entity.MovieDetailEntity
import ade.dicoding.sub2.data.local.entity.MoviesEntity
import ade.dicoding.sub2.data.local.entity.TVDetailEntity
import ade.dicoding.sub2.util.POSTER_PATH
import ade.dicoding.sub2.util.loadImageURL
import ade.dicoding.sub2.util.yesFav
import ade.dicoding.sub2.view.MyButton
import ade.dicoding.sub2.viewmodel.ViewModelFactory
import ade.dicoding.sub2.vo.Status
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
    private val isMovie by lazy { intent.getBooleanExtra(EXTRA_IS_MOVIE, true) }
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
        viewModel.setId(idContent)
        viewModel.tv.observe(this) { response ->
            Log.e("response tv", "$response")
            if (response != null) {
                when (response.status) {
                    Status.LOADING -> {

                    }
                    Status.ERROR -> {

                    }
                    Status.SUCCESS -> {
                        response.data?.apply {
                            setfav.apply {
                                if (isFavorite.yesFav()) {
                                    unfav()
                                } else {
                                    fav()
                                }

                                setOnClickListener {
                                    viewModel.setfav(response.data)
                                }
                            }

                            dtl_img.loadImageURL(POSTER_PATH + posterPath)
                            dtl_title.text = title
                            dtl_date.text = "$firstAirDate - $lastAirDate"
                            dtl_crew.text = genres
                            val desc = "Status: $status \nPopularity: $popularity \n$createdBy"
                            dtl_desc.text = desc
                            dtl_overview.text = overview
                            dtl_review.text = homepage
                        }
                    }
                }
            }

        }
    }


    private fun getMovieDetail() {
        viewModel.setId(idContent)
        viewModel.movie.observe(this) { response ->
            Log.e("response movie", "$response")
            if (response != null) {
                when (response.status) {
                    Status.LOADING -> {

                    }
                    Status.ERROR -> {

                    }
                    Status.SUCCESS -> {
                        response.data?.apply {

                            setfav.apply {
                                if (isFavorite.yesFav()) {
                                    unfav()
                                } else {
                                    fav()
                                }

                                setOnClickListener {
                                    viewModel.setfav(response.data)
                                }
                            }

                            dtl_img.loadImageURL(POSTER_PATH + posterPath)
                            dtl_title.text = title
                            dtl_date.text = releaseDate
                            dtl_crew.text = genres
                            val desc = "Status: $status \nPopularity: $popularity \n$tagline"
                            dtl_desc.text = desc
                            dtl_overview.text = overview
                            dtl_review.text = homepage

                        }
                    }
                }
            }
        }
    }

    private fun MyButton?.fav() {
        this?.text = "Favoritkan"
        this?.background = resources.getDrawable(R.drawable.bg_button)
    }

    private fun MyButton?.unfav() {
        this?.text = "Hapus Favorit"
        this?.background = resources.getDrawable(R.drawable.bg_button_disable)
    }

    companion object {
        const val EXTRA_ITEM = "EXTRA_ITEM"
        const val EXTRA_ID_CONTENT = "EXTRA_ID_CONTENT"
        const val EXTRA_IS_MOVIE = "EXTRA_IS_MOVIE"
        //        const val EXTRA_MOVIE = "EXTRA_IS_MOVIE"
        fun startMovie(
            activity: Activity?,
            entity: MoviesEntity?
        ) {

            activity?.startActivity<DetailActivity>(
                EXTRA_ITEM to entity?.title,
                EXTRA_ID_CONTENT to entity?.id,
                EXTRA_IS_MOVIE to true
//                ,
//                EXTRA_MOVIE to entity
            )
        }

        fun startMovie(
            activity: Activity?,
            entity: MovieDetailEntity?
        ) {

            activity?.startActivity<DetailActivity>(
                EXTRA_ITEM to entity?.title,
                EXTRA_ID_CONTENT to entity?.id,
                EXTRA_IS_MOVIE to true
//                ,
//                EXTRA_MOVIE to entity
            )
        }

        fun startTivi(
            activity: Activity?,
            entity: TVDetailEntity?
        ) {

            activity?.startActivity<DetailActivity>(
                EXTRA_ITEM to entity?.title,
                EXTRA_ID_CONTENT to entity?.id,
                EXTRA_IS_MOVIE to false
//                ,
//                EXTRA_MOVIE to entity
            )
        }

        fun start(
            activity: Activity?,
            item: String,
            movie: Boolean,
            id: Int?
        ) {
            activity?.startActivity<DetailActivity>(
                EXTRA_ITEM to item,
                EXTRA_ID_CONTENT to id,
                EXTRA_IS_MOVIE to false
            )
        }
    }

}
