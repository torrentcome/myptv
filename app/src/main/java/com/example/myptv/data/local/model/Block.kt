package com.example.myptv.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "block_table")
data class Block(
    @PrimaryKey @ColumnInfo("channel") var channel: String,
    @ColumnInfo("ref") var ref: String? = null
)