package com.example.myptv.data.remote.model

import com.google.gson.annotations.SerializedName

data class Stream(
    @SerializedName("channel") var channel: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("http_referrer") var httpReferrer: String? = null,
    @SerializedName("user_agent") var userAgent: String? = null
)
