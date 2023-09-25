package com.example.myptv.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "language_table")
data class Language(
    @ColumnInfo("name") var name: String? = null,
    @ColumnInfo("code") var code: String? = null
)