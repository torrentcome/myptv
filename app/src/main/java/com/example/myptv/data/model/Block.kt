package com.example.myptv.data.model

import com.google.gson.annotations.SerializedName

class Block(
    @SerializedName("channel") var channel: String? = null,
    @SerializedName("ref") var ref: String? = null
)