package com.example.myptv.data.remote.model

import com.google.gson.annotations.SerializedName

data class Region(
    @SerializedName("code") var code: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("countries") var countries: ArrayList<String> = arrayListOf()
)