package com.example.myptv.data

import com.example.myptv.data.remote.model.Block
import com.example.myptv.data.remote.model.Category
import com.example.myptv.data.remote.model.Channel
import com.example.myptv.data.remote.model.Country
import com.example.myptv.data.remote.model.Guide
import com.example.myptv.data.remote.model.Language
import com.example.myptv.data.remote.model.Region
import com.example.myptv.data.remote.ApiInterface
import com.example.myptv.data.remote.model.Stream
import com.example.myptv.data.remote.model.Subdivision

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