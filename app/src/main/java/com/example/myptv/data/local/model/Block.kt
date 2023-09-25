package com.example.myptv.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "block_table")
data class Block(
    @ColumnInfo("channel") var channel: String? = null,
    @ColumnInfo("ref") var ref: String? = null
)