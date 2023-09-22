package com.example.myptv.data.model

interface Repo {
    suspend fun getBlocklist(): List<Block>

    suspend fun getRegions(): List<Region>

    suspend fun getSubdivisions(): List<Subdivision>

    suspend fun getCountries(): List<Country>

    suspend fun getLanguages(): List<Language>

    suspend fun getCategories(): List<Category>

    suspend fun getGuides(): List<Guide>

    suspend fun getChannels(): List<Channel>

    suspend fun getStreams(): List<Stream>
}