package com.example.myptv.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myptv.data.remote.model.Stream

@Dao
interface StreamDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(stream: Stream): Long

    @Query("SELECT * FROM stream_table")
    fun loadAll(): MutableList<Stream>

    @Delete
    fun delete(song: Stream)

    @Update
    fun update(song: Stream)
}