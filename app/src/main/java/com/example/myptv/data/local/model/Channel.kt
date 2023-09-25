package com.example.myptv.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "channel_table")
data class Channel(
    @PrimaryKey @ColumnInfo("id") var id: String,
    @ColumnInfo("name") var name: String? = null,
    @ColumnInfo("alt_names") var altNames: String? = null,
    @ColumnInfo("network") var network: String? = null,
    @ColumnInfo("owners") var owners:  String? = null,
    @ColumnInfo("country") var country: String? = null,
    @ColumnInfo("subdivision") var subdivision: String? = null,
    @ColumnInfo("city") var city: String? = null,
    @ColumnInfo("broadcast_area") var broadcastArea:  String? = null,
    @ColumnInfo("languages") var languages:  String? = null,
    @ColumnInfo("categories") var categories:  String? = null,
    @ColumnInfo("is_nsfw") var isNsfw: Boolean? = null,
    @ColumnInfo("launched") var launched: String? = null,
    @ColumnInfo("closed") var closed: String? = null,
    @ColumnInfo("replaced_by") var replacedBy: String? = null,
    @ColumnInfo("website") var website: String? = null,
    @ColumnInfo("logo") var logo: String? = null
)
