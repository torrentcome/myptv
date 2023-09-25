package com.example.myptv.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myptv.data.local.model.Guide
import com.example.myptv.data.remote.model.Stream

@Dao
interface GuideDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(guide: Guide): Long

    @Query("SELECT * FROM guide_table")
    fun loadAll(): MutableList<Guide>

    @Delete
    fun delete(song: Guide)

    @Update
    fun update(song: Guide)
}