package com.example.myptv.domain.model
data class Country(
    var name: String? = null,
    var code: String? = null,
    var languages: ArrayList<String> = arrayListOf(),
    var flag: String? = null
)