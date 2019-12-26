package ade.dicoding.sub2.ui.detail

import ade.dicoding.sub2.data.model.MovieDetail
import ade.dicoding.sub2.data.model.TVDetail
import ade.dicoding.sub2.data.repository.TMDBRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class DetailViewModel(private val repository: TMDBRepository) : ViewModel() {
    fun movie(id: Int): LiveData<MovieDetail?> = repository.movieDetail(id)
    fun tv(id: Int): LiveData<TVDetail?> = repository.tVDetail(id)
}