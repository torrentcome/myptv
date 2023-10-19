package com.example.myptv.data

import com.example.myptv.data.remote.model.Block
import com.example.myptv.data.remote.model.Category
import com.example.myptv.data.remote.model.Channel
import com.example.myptv.data.remote.model.Country
import com.example.myptv.data.remote.model.Guide
import com.example.myptv.data.remote.model.Language
import com.example.myptv.data.remote.model.Region
import com.example.myptv.data.remote.model.Subdivision
import com.example.myptv.domain.base.api.ResultData
import com.example.myptv.domain.model.Stream
import kotlinx.coroutines.flow.Flow

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

    suspend fun getStreamsFlow(): Flow<ResultData<MutableList<Stream>>>
}