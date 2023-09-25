package com.example.myptv.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "category_table")
data class Category(
    @PrimaryKey @ColumnInfo("id") var id: String,
    @ColumnInfo("name") var name: String? = null
)
