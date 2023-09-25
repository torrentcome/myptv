package com.example.myptv.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "region_table")
data class Region(
    @ColumnInfo("code") var code: String,
    @ColumnInfo("name") var name: String? = null,
    @PrimaryKey @ColumnInfo("countries") var countries: String
)