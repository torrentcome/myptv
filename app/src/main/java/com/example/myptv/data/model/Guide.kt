package com.example.myptv.data.model

import com.google.gson.annotations.SerializedName

data class Guide(
    @SerializedName("channel") var channel: String? = null,
    @SerializedName("site") var site: String? = null,
    @SerializedName("lang") var lang: String? = null,
    @SerializedName("days") var days: Int? = null,
    @SerializedName("url") var url: String? = null
)