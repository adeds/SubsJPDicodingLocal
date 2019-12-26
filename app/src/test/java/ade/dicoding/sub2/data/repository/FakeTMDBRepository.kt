package ade.dicoding.sub2.data.repository

import ade.dicoding.sub2.data.model.MovieDetail
import ade.dicoding.sub2.data.model.Movies
import ade.dicoding.sub2.data.model.TVDetail
import ade.dicoding.sub2.data.model.Tivies
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeTMDBRepository(private val remoteRepository: RemoteRepository?) :
    TMDBDataSource {

    override fun movies(): LiveData<Movies?> {
        val result: MutableLiveData<Movies?> = MutableLiveData()
        remoteRepository?.getMovies(object : RemoteRepository.LoadMoviesCallback {
            override fun onAllMoviesReceived(response: Movies?) {
                return result.postValue(response)
            }

            override fun onDataNotAvailable() {}
        })
        return result
    }

    override fun movieDetail(id: Int): LiveData<MovieDetail?> {
        val result: MutableLiveData<MovieDetail?> =
            MutableLiveData()
        remoteRepository?.getMovieDetail(id, object : RemoteRepository.LoadMovieDetailCallback {
            override fun onMovieReceived(response: MovieDetail?) {
                return result.postValue(response)
            }

            override fun onDataNotAvailable() {}
        })
        return result
    }

    override fun tVShow(): LiveData<Tivies?> {
        val result: MutableLiveData<Tivies?> = MutableLiveData()
        remoteRepository?.getTv(object : RemoteRepository.LoadTVCallback {
            override fun onTVReceived(response: Tivies) {
                return result.postValue(response)
            }

            override fun onDataNotAvailable() {}
        })
        return result
    }

    override fun tVDetail(id: Int): LiveData<TVDetail?> {
        val result: MutableLiveData<TVDetail?> =
            MutableLiveData()
        remoteRepository?.getTVDetail(id, object : RemoteRepository.LoadTvDetailCallback {
            override fun onTVReceived(response: TVDetail?) {
                return result.postValue(response)
            }

            override fun onDataNotAvailable() {}
        })
        return result
    }

    companion object {
        @Volatile
        private var INSTANCE: FakeTMDBRepository? = null

        fun getInstance(remoteData: RemoteRepository?): FakeTMDBRepository? {
            if (INSTANCE == null) {
                synchronized(FakeTMDBRepository::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = FakeTMDBRepository(remoteData)
                    }
                }
            }
            return INSTANCE
        }
    }
}