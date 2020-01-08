package ade.dicoding.sub2.di

import ade.dicoding.sub2.data.dao.MovieRoomDatabase
import ade.dicoding.sub2.data.dao.TVRoomDatabase
import ade.dicoding.sub2.data.local.LocalRepository
import ade.dicoding.sub2.data.repository.TMDBRepository
import ade.dicoding.sub2.network.MovieService
import ade.dicoding.sub2.network.RetrofitBuilder
import ade.dicoding.sub2.util.AppExecutors
import android.app.Application
import android.content.Context
import retrofit2.Retrofit

object Injection {
    fun provideRepository(application: Application?): TMDBRepository? {
        val movieDatabase = MovieRoomDatabase.getInstance(application as Context)
        val tvDatabase = TVRoomDatabase.getDatabase(application as Context)
        val localRepository =
            LocalRepository.getInstance(movieDatabase?.movieDao(), tvDatabase?.tvDao())
        val appExecutors = AppExecutors()
        return TMDBRepository.getInstance(localRepository, provideApiClient(), appExecutors)
    }

    fun provideRetrofit(): RetrofitBuilder = RetrofitBuilder()
    fun provideNetworking(): Retrofit = provideRetrofit().build()
    fun provideApiClient() = provideNetworking().create(MovieService::class.java)
}