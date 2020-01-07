package ade.dicoding.sub2.di

import ade.dicoding.sub2.data.dao.MovieRoomDatabase
import ade.dicoding.sub2.data.dao.TVRoomDatabase
import ade.dicoding.sub2.data.local.LocalRepository
import ade.dicoding.sub2.data.remote.RemoteRepository
import ade.dicoding.sub2.data.repository.TMDBRepository
import ade.dicoding.sub2.util.AppExecutors
import ade.dicoding.sub2.util.FakeDummy
import android.app.Application
import android.content.Context

object Injection {
    fun provideRepository(application: Application?): TMDBRepository? {
        val movieDatabase = MovieRoomDatabase.getInstance(application as Context)
        val tvDatabase = TVRoomDatabase.getDatabase(application as Context)

        val remoteRepository = RemoteRepository.getInstance(FakeDummy(application))
        val localRepository = LocalRepository.getInstance(movieDatabase?.movieDao(),tvDatabase?.tvDao())
        val appExecutors = AppExecutors()
        return TMDBRepository.getInstance(localRepository,remoteRepository,appExecutors)
    }
}