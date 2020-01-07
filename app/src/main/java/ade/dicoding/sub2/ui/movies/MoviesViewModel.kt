package ade.dicoding.sub2.ui.movies

import ade.dicoding.sub2.data.local.entity.MoviesEntity
import ade.dicoding.sub2.data.repository.TMDBRepository
import ade.dicoding.sub2.vo.Resource
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MoviesViewModel(private val repository: TMDBRepository) : ViewModel() {
    private val user = MutableLiveData<String>()
    fun setUsername(username: String?) {
        user.value = username
    }

    var movies = Transformations.switchMap<String, Resource<List<MoviesEntity>>>(
        user
    ) { data: String? -> repository.movies() }
}