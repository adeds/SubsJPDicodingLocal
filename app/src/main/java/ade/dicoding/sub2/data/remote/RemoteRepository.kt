package ade.dicoding.sub2.data.remote

import ade.dicoding.sub2.data.model.MovieDetail
import ade.dicoding.sub2.data.model.Movies
import ade.dicoding.sub2.data.model.TVDetail
import ade.dicoding.sub2.data.model.Tivies
import ade.dicoding.sub2.util.EspressoIdlingResource
import ade.dicoding.sub2.util.FakeDummy
import ade.dicoding.sub2.util.SERVICE_LATENCY_IN_MILLIS
import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class RemoteRepository(private val jsonHelper: FakeDummy) {
    fun getMovies(): LiveData<ApiResponse<Movies?>> {
        EspressoIdlingResource.increment()
        val result: MutableLiveData<ApiResponse<Movies?>> = MutableLiveData()

        Handler().postDelayed(
            {
                result.postValue(ApiResponse.success(jsonHelper.generateMovies()))
                if (!EspressoIdlingResource.idlingResource.isIdleNow)
                    EspressoIdlingResource.decrement()
            },
            SERVICE_LATENCY_IN_MILLIS
        )
        return result
    }
    fun getTv(): LiveData<ApiResponse<Tivies?>> {
        EspressoIdlingResource.increment()
        val result: MutableLiveData<ApiResponse<Tivies?>> = MutableLiveData()

        val handler = Handler()
        handler.postDelayed({
            result.postValue(ApiResponse.success(jsonHelper.generateTivies()))
            if (!EspressoIdlingResource.idlingResource.isIdleNow)
                EspressoIdlingResource.decrement()

        }, SERVICE_LATENCY_IN_MILLIS)
        return result
    }
    fun getMovieDetail(id: Int): LiveData<ApiResponse<MovieDetail?>> {
        val handler = Handler()
        val result: MutableLiveData<ApiResponse<MovieDetail?>> = MutableLiveData()

        EspressoIdlingResource.increment()
        handler.postDelayed({
            result.postValue(
                ApiResponse.success(
                    jsonHelper.generateMovieDetail(id)
                )
            )
            if (!EspressoIdlingResource.idlingResource.isIdleNow)
                EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return result
    }

    fun getTVDetail(id: Int): LiveData<ApiResponse<TVDetail?>> {
        val handler = Handler()
        val result: MutableLiveData<ApiResponse<TVDetail?>> = MutableLiveData()

        EspressoIdlingResource.increment()
        handler.postDelayed({
            result.postValue(
                ApiResponse.success(
                    jsonHelper.generateTVDetail(id)
                )
            )
            if (!EspressoIdlingResource.idlingResource.isIdleNow)
                EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return result
    }

    companion object {
        private var INSTANCE: RemoteRepository? = null
        fun getInstance(helper: FakeDummy): RemoteRepository? {
            if (INSTANCE == null) {
                INSTANCE =
                    RemoteRepository(helper)
            }
            return INSTANCE
        }
    }
}