package com.example.myptv.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "country_table")
data class Country(
    @ColumnInfo("name") var name: String,
    @PrimaryKey @ColumnInfo("code") var code: String,
    @ColumnInfo("languages") var languages: String? = null,
    @ColumnInfo("flag") var flag: String? = null
)