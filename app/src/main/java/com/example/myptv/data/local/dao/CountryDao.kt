package com.example.myptv.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myptv.data.local.model.Country
import com.example.myptv.data.remote.model.Stream

@Dao
interface CountryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(country: Country): Long

    @Query("SELECT * FROM country_table")
    fun loadAll(): MutableList<Country>

    @Delete
    fun delete(song: Country)

    @Update
    fun update(song: Country)
}