package ade.dicoding.sub2.ui.favorites.movie

import ade.dicoding.sub2.data.local.entity.MovieDetailEntity
import ade.dicoding.sub2.data.repository.TMDBRepository
import ade.dicoding.sub2.helper.SortUtils.NEWEST
import ade.dicoding.sub2.vo.Resource
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList

class MoviesFavViewModel(private val repository: TMDBRepository) : ViewModel() {
    private val sorter = MutableLiveData<String>()
    fun setSorter(username: String?) {
        sorter.value = username
    }

    var movies = Transformations.switchMap<String, Resource<PagedList<MovieDetailEntity>>>(
        sorter
    ) { data: String? -> repository.favMovies(data ?: NEWEST) }
}