package ade.dicoding.sub2.ui.tvshow

import ade.dicoding.sub2.data.local.entity.TiviesEntity
import ade.dicoding.sub2.data.repository.TMDBRepository
import ade.dicoding.sub2.vo.Resource
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class TVViewModel(private val repository: TMDBRepository) : ViewModel() {
    //    fun tivies(): LiveData<Tivies?> = repository.tVShow()
    private val user = MutableLiveData<String>()

    fun setUsername(username: String?) {
        user.value = username
    }

    var tivies = Transformations.switchMap<String, Resource<List<TiviesEntity>>>(
        user
    ) { data: String? -> repository.tVShow() }
}