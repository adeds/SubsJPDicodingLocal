package ade.dicoding.sub2.data.dao

import ade.dicoding.sub2.data.local.entity.MovieDetailEntity
import ade.dicoding.sub2.data.local.entity.MoviesEntity
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery


@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movies: MoviesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetail(moviesDetail: MovieDetailEntity?)

    @Update
    fun updateMovies(movies: MoviesEntity)

    @Update
    fun updateMovieDetail(movies: MovieDetailEntity)

    @get:Query("SELECT * from movies_entity")
    val allMovies: LiveData<List<MoviesEntity>>

    @Transaction
    @Query("SELECT * from moviedetail WHERE id= :idMovie")
    fun movieDetail(idMovie:Int): LiveData<MovieDetailEntity>

    @RawQuery(observedEntities = [MovieDetailEntity::class])
    fun allMoviesDetail(query: SupportSQLiteQuery?): DataSource.Factory<Int?, MovieDetailEntity?>?

}