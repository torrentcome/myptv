package com.example.myptv.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myptv.data.local.model.Stream
import kotlinx.coroutines.flow.Flow

@Dao
interface StreamDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(stream: Stream): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(list: List<Stream>): List<Long>

    @Query("SELECT * FROM stream_table")
    fun loadAll(): List<Stream>

    @Query("SELECT * FROM stream_table WHERE url LIKE :url")
    fun load(url:String): List<Stream>

    @Query("SELECT * FROM stream_table")
    fun loadAllFlow(): Flow<List<Stream>>

    @Delete
    fun delete(stream: Stream)

    @Update
    fun update(stream: Stream)

    @Query("SELECT COUNT(*) FROM stream_table")
    fun getCount(): Int
}