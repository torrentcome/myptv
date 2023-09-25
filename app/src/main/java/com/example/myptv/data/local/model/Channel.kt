package com.example.myptv.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "channel_table")
data class Channel(
    @ColumnInfo("id") var id: String? = null,
    @ColumnInfo("name") var name: String? = null,
    @ColumnInfo("alt_names") var altNames: ArrayList<String> = arrayListOf(),
    @ColumnInfo("network") var network: String? = null,
    @ColumnInfo("owners") var owners: ArrayList<String> = arrayListOf(),
    @ColumnInfo("country") var country: String? = null,
    @ColumnInfo("subdivision") var subdivision: String? = null,
    @ColumnInfo("city") var city: String? = null,
    @ColumnInfo("broadcast_area") var broadcastArea: ArrayList<String> = arrayListOf(),
    @ColumnInfo("languages") var languages: ArrayList<String> = arrayListOf(),
    @ColumnInfo("categories") var categories: ArrayList<String> = arrayListOf(),
    @ColumnInfo("is_nsfw") var isNsfw: Boolean? = null,
    @ColumnInfo("launched") var launched: String? = null,
    @ColumnInfo("closed") var closed: String? = null,
    @ColumnInfo("replaced_by") var replacedBy: String? = null,
    @ColumnInfo("website") var website: String? = null,
    @ColumnInfo("logo") var logo: String? = null
)
