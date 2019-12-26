package ade.dicoding.sub2.viewmodel

import ade.dicoding.sub2.data.repository.TMDBRepository
import ade.dicoding.sub2.di.Injection
import ade.dicoding.sub2.ui.detail.DetailViewModel
import ade.dicoding.sub2.ui.movies.MoviesViewModel
import ade.dicoding.sub2.ui.tvshow.TVViewModel
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory

class ViewModelFactory private constructor(academyRepository: TMDBRepository) :
    NewInstanceFactory() {
    private val mAcademyRepository: TMDBRepository
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoviesViewModel::class.java)) {
            return MoviesViewModel(mAcademyRepository) as T
        } else if (modelClass.isAssignableFrom(TVViewModel::class.java)) {
            return TVViewModel(mAcademyRepository) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(mAcademyRepository) as T
        }
//        } else if (modelClass.isAssignableFrom(CourseReaderViewModel::class.java)) {
//            return CourseReaderViewModel(mAcademyRepository) as T
//        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application): ViewModelFactory? {
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

    init {
        mAcademyRepository = academyRepository
    }
}