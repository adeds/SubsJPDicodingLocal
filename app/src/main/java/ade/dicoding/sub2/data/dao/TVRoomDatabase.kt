package ade.dicoding.sub2.data.dao

import ade.dicoding.sub2.data.local.entity.TVDetailEntity
import ade.dicoding.sub2.data.local.entity.TiviesEntity
import ade.dicoding.sub2.data.model.TVDetail
import ade.dicoding.sub2.data.model.Tivies
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [TiviesEntity::class, TVDetailEntity::class]
    , version = 1
    , exportSchema = false
)

abstract class TVRoomDatabase : RoomDatabase() {
    abstract fun tvDao(): TVDao

    companion object {
        @Volatile
        private var INSTANCE: TVRoomDatabase? = null
        private val sLock = Object()

        fun getDatabase(context: Context): TVRoomDatabase? {
            synchronized(sLock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        TVRoomDatabase::class.java, "tv_database"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}