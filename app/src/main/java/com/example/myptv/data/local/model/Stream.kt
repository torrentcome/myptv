package com.example.myptv.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stream_table")
data class Stream(
    @PrimaryKey @ColumnInfo("url")  var url: String,
    @ColumnInfo("channel") var channel: String? = null,
    @ColumnInfo("http_referrer") var httpReferrer: String? = null,
    @ColumnInfo("user_agent") var userAgent: String? = null
)
