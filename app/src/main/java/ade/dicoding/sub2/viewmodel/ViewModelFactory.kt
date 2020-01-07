package ade.dicoding.sub2.viewmodel

import ade.dicoding.sub2.data.repository.TMDBRepository
import ade.dicoding.sub2.di.Injection
import ade.dicoding.sub2.ui.detail.DetailViewModel
import ade.dicoding.sub2.ui.favorites.movie.MoviesFavViewModel
import ade.dicoding.sub2.ui.favorites.tivshow.TVFavViewModel
import ade.dicoding.sub2.ui.movies.MoviesViewModel
import ade.dicoding.sub2.ui.tvshow.TVViewModel
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory

class ViewModelFactory private constructor(private val mAcademyRepository: TMDBRepository) :
    NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                MoviesViewModel(mAcademyRepository) as T
            }
            modelClass.isAssignableFrom(TVViewModel::class.java) -> {
                TVViewModel(mAcademyRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(mAcademyRepository) as T
            }
            modelClass.isAssignableFrom(MoviesFavViewModel::class.java) -> {
                MoviesFavViewModel(mAcademyRepository) as T
            }
            modelClass.isAssignableFrom(TVFavViewModel::class.java) -> {
                TVFavViewModel(mAcademyRepository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application?): ViewModelFactory? {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE =
                            Injection.provideRepository(application)?.let { ViewModelFactory(it) }
                    }
                }
            }
            return INSTANCE
        }
    }

}