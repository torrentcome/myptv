package com.example.myptv.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "country_table")
data class Country(
    @ColumnInfo("name") var name: String? = null,
    @ColumnInfo("code") var code: String? = null,
    @ColumnInfo("languages") var languages: ArrayList<String> = arrayListOf(),
    @ColumnInfo("flag") var flag: String? = null
)