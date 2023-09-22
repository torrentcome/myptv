package com.example.myptv.data.model

import com.google.gson.annotations.SerializedName

data class Channel(
    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("alt_names") var altNames: ArrayList<String> = arrayListOf(),
    @SerializedName("network") var network: String? = null,
    @SerializedName("owners") var owners: ArrayList<String> = arrayListOf(),
    @SerializedName("country") var country: String? = null,
    @SerializedName("subdivision") var subdivision: String? = null,
    @SerializedName("city") var city: String? = null,
    @SerializedName("broadcast_area") var broadcastArea: ArrayList<String> = arrayListOf(),
    @SerializedName("languages") var languages: ArrayList<String> = arrayListOf(),
    @SerializedName("categories") var categories: ArrayList<String> = arrayListOf(),
    @SerializedName("is_nsfw") var isNsfw: Boolean? = null,
    @SerializedName("launched") var launched: String? = null,
    @SerializedName("closed") var closed: String? = null,
    @SerializedName("replaced_by") var replacedBy: String? = null,
    @SerializedName("website") var website: String? = null,
    @SerializedName("logo") var logo: String? = null
)
