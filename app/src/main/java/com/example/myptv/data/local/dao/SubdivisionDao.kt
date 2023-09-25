package com.example.myptv.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myptv.data.local.model.Subdivision
import com.example.myptv.data.remote.model.Stream

@Dao
interface SubdivisionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(subdivision: Subdivision): Long

    @Query("SELECT * FROM subdivision_table")
    fun loadAll(): MutableList<Subdivision>

    @Delete
    fun delete(song: Subdivision)

    @Update
    fun update(song: Subdivision)
}