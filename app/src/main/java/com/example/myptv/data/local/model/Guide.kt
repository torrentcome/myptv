package com.example.myptv.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "guide_table")
data class Guide(
    @ColumnInfo("channel") var channel: String? = null,
    @ColumnInfo("site") var site: String? = null,
    @ColumnInfo("lang") var lang: String? = null,
    @ColumnInfo("days") var days: Int? = null,
    @ColumnInfo("url") var url: String? = null
)