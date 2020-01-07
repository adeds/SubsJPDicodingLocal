package ade.dicoding.sub2.ui.favorites.tivshow

import ade.dicoding.sub2.data.local.entity.TVDetailEntity
import ade.dicoding.sub2.data.repository.TMDBRepository
import ade.dicoding.sub2.helper.SortUtils.NEWEST
import ade.dicoding.sub2.vo.Resource
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList

class TVFavViewModel(private val repository: TMDBRepository) : ViewModel() {
    private val sorter = MutableLiveData<String>()
    fun setSorter(username: String?) {
        sorter.value = username
    }

    var tivies = Transformations.switchMap<String, Resource<PagedList<TVDetailEntity>>>(
        sorter
    ) { data: String? -> repository.favTivies(data ?: NEWEST) }
}