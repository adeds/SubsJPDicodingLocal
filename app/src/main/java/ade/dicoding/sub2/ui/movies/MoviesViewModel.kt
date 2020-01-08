package ade.dicoding.sub2.ui.movies

import ade.dicoding.sub2.data.local.entity.MoviesEntity
import ade.dicoding.sub2.data.model.Movies
import ade.dicoding.sub2.data.remote.ApiResponse
import ade.dicoding.sub2.data.repository.TMDBRepository
import ade.dicoding.sub2.vo.Resource
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MoviesViewModel(private val repository: TMDBRepository) : ViewModel() {
    private val page = MutableLiveData<Int>()
    private val keyword = MutableLiveData<String>()
    fun setPage(username: Int?) {
        page.value = username
    }

    fun search(word: String?) {
        keyword.value = word
    }

    var movies = Transformations.switchMap<Int, Resource<List<MoviesEntity>>>(
        page
    ) { data: Int? -> repository.movies(data) }

    var movieSearch = Transformations.switchMap<String, ApiResponse<Movies>>(keyword) {
            data: String? -> repository.movies(data) }

    fun getMovieValue() = movies.value

}