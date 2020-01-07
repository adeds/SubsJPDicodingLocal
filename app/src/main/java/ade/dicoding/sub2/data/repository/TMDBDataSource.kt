package ade.dicoding.sub2.data.repository

import ade.dicoding.sub2.data.local.entity.MovieDetailEntity
import ade.dicoding.sub2.data.local.entity.MoviesEntity
import ade.dicoding.sub2.data.local.entity.TVDetailEntity
import ade.dicoding.sub2.data.local.entity.TiviesEntity
import ade.dicoding.sub2.data.model.*
import ade.dicoding.sub2.vo.Resource
import androidx.lifecycle.LiveData
import androidx.paging.PagedList

interface TMDBDataSource {
    fun movies(): LiveData<Resource<List<MoviesEntity>>>?
    fun favMovies(sort:String): LiveData<Resource<PagedList<MovieDetailEntity>>>?
    fun favTivies(sort:String): LiveData<Resource<PagedList<TVDetailEntity>>>?
    fun movieDetail(id: Int): LiveData<Resource<MovieDetailEntity>>
    fun tVShow(): LiveData<Resource<List<TiviesEntity>>>?
    fun tVDetail(id: Int): LiveData<Resource<TVDetailEntity>>

    fun setFavMovie(movieDetail: MovieDetailEntity)
    fun setFavTV(tvDetail: TVDetailEntity)
}