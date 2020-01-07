package ade.dicoding.sub2.data.dao

import ade.dicoding.sub2.data.local.entity.MovieDetailEntity
import ade.dicoding.sub2.data.model.MovieDetail
import ade.dicoding.sub2.data.local.entity.MoviesEntity
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities =
    [MoviesEntity::class,
        MovieDetailEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MovieRoomDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        @Volatile
        private var INSTANCE: MovieRoomDatabase? = null
        private val sLock = Object()

        fun getInstance(context: Context): MovieRoomDatabase? {
            synchronized(sLock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MovieRoomDatabase::class.java, "movies_database"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}