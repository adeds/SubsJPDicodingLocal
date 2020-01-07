package ade.dicoding.sub2.ui.detail

import ade.dicoding.sub2.data.local.entity.MovieDetailEntity
import ade.dicoding.sub2.data.local.entity.TVDetailEntity
import ade.dicoding.sub2.data.repository.TMDBRepository
import ade.dicoding.sub2.vo.Resource
import androidx.lifecycle.*

class DetailViewModel(private val repository: TMDBRepository) : ViewModel() {
    private val id = MutableLiveData<Int>()

    fun setId(id2: Int) {
        id.value = id2
    }

    val movie: LiveData<Resource<MovieDetailEntity>>
    val tv: LiveData<Resource<TVDetailEntity>>

    fun setfav(entiti: MovieDetailEntity) = repository.setFavMovie(entiti)
    fun setfav(entiti: TVDetailEntity) = repository.setFavTV(entiti)

    init {
        movie = id.switchMap {
            repository.movieDetail(it)
        }
        tv= id.switchMap {
            repository.tVDetail(it)
        }
    }
}
