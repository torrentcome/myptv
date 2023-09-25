package com.example.myptv.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "stream_table")
data class Stream(
    @PrimaryKey @ColumnInfo("channel") var channel: String,
    @ColumnInfo("url") var url: String? = null,
    @ColumnInfo("http_referrer") var httpReferrer: String? = null,
    @ColumnInfo("user_agent") var userAgent: String? = null
)
