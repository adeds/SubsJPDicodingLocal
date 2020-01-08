package ade.dicoding.sub2.data.local

import ade.dicoding.sub2.data.dao.MovieDao
import ade.dicoding.sub2.data.dao.TVDao
import ade.dicoding.sub2.data.local.entity.MovieDetailEntity
import ade.dicoding.sub2.data.local.entity.MoviesEntity
import ade.dicoding.sub2.data.local.entity.TVDetailEntity
import ade.dicoding.sub2.data.local.entity.TiviesEntity
import ade.dicoding.sub2.helper.SortUtils
import ade.dicoding.sub2.util.timeStamp
import ade.dicoding.sub2.util.yesFav
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.sqlite.db.SimpleSQLiteQuery

class LocalRepository(private val movieDao: MovieDao?, private val tvDao: TVDao?) {
    fun getAllMovie(page: Int?): LiveData<List<MoviesEntity>>? {
        return page?.let { movieDao?.allMovies(it) }
    }

    fun getMovieDetail(idMovie:Int): LiveData<MovieDetailEntity>? {
        return movieDao?.movieDetail(idMovie)
    }

    fun insertMovies(movies: MutableList<MoviesEntity>) {
        movieDao?.insert(movies)
    }

    fun insertMovieDetail(movieDetail: MovieDetailEntity?) {
        movieDao?.insertDetail(movieDetail)
    }

    fun updateMovies(movies: MoviesEntity) {
        movieDao?.updateMovies(movies)
    }

    fun updateMovieDetail(movieDetail: MovieDetailEntity) {
        movieDao?.updateMovieDetail(movieDetail)
    }

    fun getAllMovieDetail(sort: String): DataSource.Factory<Int?, MovieDetailEntity?>? {
        val query: SimpleSQLiteQuery = SortUtils.getSorteredMovie(sort)
        return movieDao?.allMoviesDetail(query)
    }


    fun setFavMovie(movieDetail: MovieDetailEntity) {
        if (movieDetail.isFavorite.yesFav())
            movieDetail.isFavorite = 0
        else movieDetail.isFavorite = timeStamp()
        movieDao?.updateMovieDetail(movieDetail)
    }


    fun getAllTivi(): LiveData<List<TiviesEntity>>? {
        return tvDao?.allTivies
    }

    fun getTVDetail(idTV:Int): LiveData<TVDetailEntity>? {
        return tvDao?.tvDetail(idTV)
    }


    fun insertTivies(tivies: TiviesEntity) {
        tvDao?.insert(tivies)
    }

    fun insertTVDetail(TV: TVDetailEntity?) {
        tvDao?.insertDetail(TV)
    }

    fun updateTivies(movies: TiviesEntity) {
        tvDao?.updateTivies(movies)
    }

    fun updateTVDetail(tvDetail: TVDetailEntity) {
        tvDao?.updateTvDetaik(tvDetail)
    }

    fun getAllTVDetail(sort: String): DataSource.Factory<Int?, TVDetailEntity?>? {
        val query: SimpleSQLiteQuery = SortUtils.getSorteredTV(sort)
        return tvDao?.allTVDetail(query)
    }


    fun setFavTV(tvDetail: TVDetailEntity) {
        if (tvDetail.isFavorite.yesFav())
            tvDetail.isFavorite = 0
        else tvDetail.isFavorite = timeStamp()
        tvDao?.updateTvDetaik(tvDetail)
    }

    companion object {
        private var INSTANCE: LocalRepository? = null
        fun getInstance(movieDao: MovieDao?, tvDao: TVDao?): LocalRepository? {
            if (INSTANCE == null) {
                INSTANCE = LocalRepository(movieDao, tvDao)
            }
            return INSTANCE
        }
    }
}