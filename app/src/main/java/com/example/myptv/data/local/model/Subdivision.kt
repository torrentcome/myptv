package com.example.myptv.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "subdivision_table")
data class Subdivision(
    @PrimaryKey @ColumnInfo("country") var country: String,
    @ColumnInfo("name") var name: String? = null,
    @ColumnInfo("code") var code: String? = null
)