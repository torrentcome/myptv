package com.example.myptv.data.remote

import com.example.myptv.data.remote.model.Block
import com.example.myptv.data.remote.model.Category
import com.example.myptv.data.remote.model.Channel
import com.example.myptv.data.remote.model.Country
import com.example.myptv.data.remote.model.Guide
import com.example.myptv.data.remote.model.Language
import com.example.myptv.data.remote.model.Region
import com.example.myptv.data.remote.model.Stream
import com.example.myptv.data.remote.model.Subdivision
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