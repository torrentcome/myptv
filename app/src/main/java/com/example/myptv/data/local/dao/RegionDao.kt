package com.example.myptv.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myptv.data.local.model.Region
import com.example.myptv.data.remote.model.Stream

@Dao
interface RegionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(region: Region): Long

    @Query("SELECT * FROM region_table")
    fun loadAll(): MutableList<Region>

    @Delete
    fun delete(song: Region)

    @Update
    fun update(song: Region)
}