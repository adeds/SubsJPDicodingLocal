package ade.dicoding.sub2.data.repository

import ade.dicoding.sub2.data.model.MovieDetail
import ade.dicoding.sub2.data.model.Movies
import ade.dicoding.sub2.data.model.TVDetail
import ade.dicoding.sub2.data.model.Tivies
import androidx.lifecycle.LiveData

interface TMDBDataSource {
    fun movies():LiveData<Movies?>
    fun movieDetail(id:Int): LiveData<MovieDetail?>
    fun tVShow(): LiveData<Tivies?>
    fun tVDetail(id:Int): LiveData<TVDetail?>
}