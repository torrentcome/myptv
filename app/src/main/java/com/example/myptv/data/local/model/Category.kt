package com.example.myptv.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "category_table")
data class Category(
    @ColumnInfo("id") var id: String? = null,
    @ColumnInfo("name") var name: String? = null
)
