package com.example.myptv.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myptv.data.local.model.Language
import com.example.myptv.data.remote.model.Stream

@Dao
interface LanguageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(language: Language): Long

    @Query("SELECT * FROM language_table")
    fun loadAll(): MutableList<Language>

    @Delete
    fun delete(song: Language)

    @Update
    fun update(song: Language)
}