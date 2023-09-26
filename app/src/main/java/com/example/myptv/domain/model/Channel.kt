package com.example.myptv.domain.model

data class Channel(
    var id: String? = null,
    var name: String? = null,
    var altNames: ArrayList<String> = arrayListOf(),
    var network: String? = null,
    var owners: ArrayList<String> = arrayListOf(),
    var country: String? = null,
    var subdivision: String? = null,
    var city: String? = null,
    var broadcastArea: ArrayList<String> = arrayListOf(),
    var languages: ArrayList<String> = arrayListOf(),
    var categories: ArrayList<String> = arrayListOf(),
    var isNsfw: Boolean? = null,
    var launched: String? = null,
    var closed: String? = null,
    var replacedBy: String? = null,
    var website: String? = null,
    var logo: String? = null
)
