package com.example.myptv.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "region_table")
data class Region(
    @ColumnInfo("code") var code: String? = null,
    @ColumnInfo("name") var name: String? = null,
    @ColumnInfo("countries") var countries: ArrayList<String> = arrayListOf()
)