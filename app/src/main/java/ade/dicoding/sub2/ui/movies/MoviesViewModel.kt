package ade.dicoding.sub2.ui.movies

import ade.dicoding.sub2.data.model.Movies
import ade.dicoding.sub2.data.repository.TMDBRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MoviesViewModel(private val repository: TMDBRepository) : ViewModel() {
    fun movies(): LiveData<Movies?> = repository.movies()

}