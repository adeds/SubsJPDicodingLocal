package ade.dicoding.sub2.data.dao

import ade.dicoding.sub2.data.local.entity.TVDetailEntity
import ade.dicoding.sub2.data.local.entity.TiviesEntity
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery


@Dao
interface TVDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tivies: TiviesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetail(tvDetail: TVDetailEntity?)


    @Update
    fun updateTivies(tivies: TiviesEntity)

    @Update
    fun updateTvDetaik(tvDetail: TVDetailEntity)

    @Delete
    fun delete(tivies: TiviesEntity?)

    @get:Query("SELECT * from Tivies")
    val allTivies: LiveData<List<TiviesEntity>>

    @Transaction
    @Query("SELECT * from tvdetail WHERE id= :idTV")
    fun tvDetail(idTV:Int): LiveData<TVDetailEntity>

    @RawQuery(observedEntities = [TVDetailEntity::class])
    fun allTVDetail(query: SupportSQLiteQuery?): DataSource.Factory<Int?, TVDetailEntity?>?

}