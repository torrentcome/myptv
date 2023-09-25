package com.example.myptv.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "guide_table")
data class Guide(
    @PrimaryKey @ColumnInfo("channel") var channel: String,
    @ColumnInfo("site") var site: String? = null,
    @ColumnInfo("lang") var lang: String? = null,
    @ColumnInfo("days") var days: Int? = null,
    @ColumnInfo("url") var url: String? = null
)