package com.example.myptv.data.model

import com.google.gson.annotations.SerializedName

class Subdivision(
    @SerializedName("country") var country: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("code") var code: String? = null
)