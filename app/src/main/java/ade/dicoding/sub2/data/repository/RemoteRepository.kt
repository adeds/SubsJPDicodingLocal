package ade.dicoding.sub2.data.repository

import ade.dicoding.sub2.data.model.MovieDetail
import ade.dicoding.sub2.data.model.Movies
import ade.dicoding.sub2.data.model.TVDetail
import ade.dicoding.sub2.data.model.Tivies
import ade.dicoding.sub2.util.EspressoIdlingResource
import ade.dicoding.sub2.util.FakeDummy
import ade.dicoding.sub2.util.SERVICE_LATENCY_IN_MILLIS
import android.os.Handler

class RemoteRepository(private val jsonHelper: FakeDummy) {
    fun getMovies(callback: LoadMoviesCallback) {
        EspressoIdlingResource.increment()
        Handler().postDelayed(
            {
                callback.onAllMoviesReceived(jsonHelper.generateMovies())
                EspressoIdlingResource.decrement()
            },
            SERVICE_LATENCY_IN_MILLIS
        )
    }

    fun getMovieDetail(id: Int, callback: LoadMovieDetailCallback) {
        val handler = Handler()
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onMovieReceived(
                jsonHelper.generateMovieDetail(id)
            )
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getTVDetail(id: Int, callback: LoadTvDetailCallback) {
        val handler = Handler()
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onTVReceived(
                jsonHelper.generateTVDetail(id)
            )
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getTv(callback: LoadTVCallback) {
        EspressoIdlingResource.increment()
        val handler = Handler()
        handler.postDelayed({
            callback.onTVReceived(
                jsonHelper.generateTivies()
            )
            EspressoIdlingResource.decrement()

        }, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(response: Movies?)
        fun onDataNotAvailable()
    }

    interface LoadTVCallback {
        fun onTVReceived(response: Tivies)
        fun onDataNotAvailable()
    }

    interface LoadMovieDetailCallback {
        fun onMovieReceived(contentResponse: MovieDetail?)
        fun onDataNotAvailable()
    }

    interface LoadTvDetailCallback {
        fun onTVReceived(contentResponse: TVDetail?)
        fun onDataNotAvailable()
    }

    companion object {
        private var INSTANCE: RemoteRepository? = null
        fun getInstance(helper: FakeDummy): RemoteRepository? {
            if (INSTANCE == null) {
                INSTANCE = RemoteRepository(helper)
            }
            return INSTANCE
        }
    }
}