package com.example.myptv.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myptv.data.local.model.Channel
import com.example.myptv.data.remote.model.Stream

@Dao
interface ChannelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(channel: Channel): Long

    @Query("SELECT * FROM channel_table")
    fun loadAll(): MutableList<Channel>

    @Delete
    fun delete(song: Channel)

    @Update
    fun update(song: Channel)
}