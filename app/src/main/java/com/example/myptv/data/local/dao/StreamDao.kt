package com.example.myptv.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myptv.data.local.model.Stream

@Dao
interface StreamDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(stream: Stream): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(list: List<Stream>): List<Long>

    @Query("SELECT * FROM stream_table")
    fun loadAll(): MutableList<Stream>

    @Delete
    fun delete(song: Stream)

    @Update
    fun update(song: Stream)
}