package com.example.myptv.data.remote.model

import com.google.gson.annotations.SerializedName

data class Language(
    @SerializedName("name") var name: String? = null,
    @SerializedName("code") var code: String? = null
)