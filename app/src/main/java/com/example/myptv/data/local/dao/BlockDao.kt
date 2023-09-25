package com.example.myptv.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myptv.data.local.model.Block
import com.example.myptv.data.remote.model.Stream

@Dao
interface BlockDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(block: Block): Long

    @Query("SELECT * FROM block_table")
    fun loadAll(): MutableList<Block>

    @Delete
    fun delete(song: Block)

    @Update
    fun update(song: Block)
}