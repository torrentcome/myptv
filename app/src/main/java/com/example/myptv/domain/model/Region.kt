package com.example.myptv.domain.model
data class Region(
    var code: String? = null,
    var name: String? = null,
    var countries: ArrayList<String> = arrayListOf()
)