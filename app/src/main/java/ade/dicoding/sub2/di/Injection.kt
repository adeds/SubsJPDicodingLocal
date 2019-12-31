package ade.dicoding.sub2.di

import ade.dicoding.sub2.data.repository.RemoteRepository
import ade.dicoding.sub2.data.repository.TMDBRepository
import ade.dicoding.sub2.util.FakeDummy
import android.app.Application

object Injection {
    fun provideRepository(application: Application?): TMDBRepository? {
        val remoteRepository = RemoteRepository.getInstance(FakeDummy(application))
        return TMDBRepository.getInstance(remoteRepository)
    }
}