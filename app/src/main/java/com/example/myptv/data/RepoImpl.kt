package com.example.myptv.data

import com.example.myptv.data.model.Block
import com.example.myptv.data.model.Category
import com.example.myptv.data.model.Channel
import com.example.myptv.data.model.Country
import com.example.myptv.data.model.Guide
import com.example.myptv.data.model.Language
import com.example.myptv.data.model.Region
import com.example.myptv.data.model.Repo
import com.example.myptv.data.model.Stream
import com.example.myptv.data.model.Subdivision
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class RepoImpl(private val api: ApiInterface) : Repo {

    override suspend fun getBlocklist(): List<Block> {
        return api.getBlocklist()
    }

    override suspend fun getRegions(): List<Region> {
        return api.getRegions()
    }

    override suspend fun getSubdivisions(): List<Subdivision> {
        return api.getSubdivisions()
    }

    override suspend fun getCountries(): List<Country> {
        return api.getCountries()
    }

    override suspend fun getLanguages(): List<Language> {
        return api.getLanguages()
    }

    override suspend fun getCategories(): List<Category> {
        return api.getCategories()
    }

    override suspend fun getGuides(): List<Guide> {
        return api.getGuides()
    }

    override suspend fun getChannels(): List<Channel> {
        return api.getChannels()
    }

    override suspend fun getStreams(): List<Stream> {
        return api.getStreams()
    }
}