package com.example.myptv.data

import com.example.myptv.data.model.Block
import com.example.myptv.data.model.Category
import com.example.myptv.data.model.Channel
import com.example.myptv.data.model.Country
import com.example.myptv.data.model.Guide
import com.example.myptv.data.model.Language
import com.example.myptv.data.model.Region
import com.example.myptv.data.model.Stream
import com.example.myptv.data.model.Subdivision
import retrofit2.http.GET

interface ApiInterface {
    @GET("blocklist.json")
    suspend fun getBlocklist(): List<Block>

    @GET("regions.json")
    suspend fun getRegions(): List<Region>

    @GET("subdivisions.json")
    suspend fun getSubdivisions(): List<Subdivision>

    @GET("countries.json")
    suspend fun getCountries(): List<Country>

    @GET("languages.json")
    suspend fun getLanguages(): List<Language>

    @GET("categories.json")
    suspend fun getCategories(): List<Category>

    @GET("guides.json")
    suspend fun getGuides(): List<Guide>

    @GET("channels.json")
    suspend fun getChannels(): List<Channel>

    @GET("streams.json")
    suspend fun getStreams(): List<Stream>
}