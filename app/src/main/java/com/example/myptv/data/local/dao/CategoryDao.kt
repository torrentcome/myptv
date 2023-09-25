package com.example.myptv.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myptv.data.local.model.Category
import com.example.myptv.data.remote.model.Stream

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(category: Category): Long

    @Query("SELECT * FROM category_table")
    fun loadAll(): MutableList<Category>

    @Delete
    fun delete(song: Category)

    @Update
    fun update(song: Category)
}