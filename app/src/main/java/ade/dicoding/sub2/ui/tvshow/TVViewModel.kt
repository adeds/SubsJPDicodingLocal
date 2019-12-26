package ade.dicoding.sub2.ui.tvshow

import ade.dicoding.sub2.data.model.Tivies
import ade.dicoding.sub2.data.repository.TMDBRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class TVViewModel(private val repository: TMDBRepository) : ViewModel() {
    fun tivies(): LiveData<Tivies?> = repository.tVShow()
}