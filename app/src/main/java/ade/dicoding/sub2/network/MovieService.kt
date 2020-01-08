package ade.dicoding.sub2.network

import ade.dicoding.sub2.data.model.MovieDetail
import ade.dicoding.sub2.data.model.Movies
import ade.dicoding.sub2.data.model.TVDetail
import ade.dicoding.sub2.data.model.Tivies
import ade.dicoding.sub2.data.remote.ApiResponse
import androidx.lifecycle.LiveData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("3/movie/upcoming?language=id-ID")
    fun getMovie(@Query("page")page: Int?): LiveData<ApiResponse<Movies>>

    @GET("3/search/movie?&language=en-US&page=1")
    fun getMovie(@Query("query")key: String?): LiveData<ApiResponse<Movies>>

    @GET("3/tv/on_the_air?language=id-ID&page=1")
    fun getTV(): LiveData<ApiResponse<Tivies>>

    @GET("3/movie/{mov_id}?language=id-ID")
    fun getMovieDetail(@Path("mov_id") movId: Int): LiveData<ApiResponse<MovieDetail>>

    @GET("3/tv/{tv_id}?language=id-ID")
    fun getTVDetail(@Path("tv_id") tvId: Int): LiveData<ApiResponse<TVDetail>>
}