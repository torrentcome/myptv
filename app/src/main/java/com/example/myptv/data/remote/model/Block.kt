package com.example.myptv.data.remote.model

import com.google.gson.annotations.SerializedName

data class Block(
    @SerializedName("channel") var channel: String? = null,
    @SerializedName("ref") var ref: String? = null
)