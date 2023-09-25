package com.example.myptv.data.remote.model

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name") var name: String? = null,
    @SerializedName("code") var code: String? = null,
    @SerializedName("languages") var languages: ArrayList<String> = arrayListOf(),
    @SerializedName("flag") var flag: String? = null
)