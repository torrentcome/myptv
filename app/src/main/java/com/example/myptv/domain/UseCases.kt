package com.example.myptv.domain

import com.example.myptv.data.RepoImpl
import com.example.myptv.data.remote.model.Block
import com.example.myptv.data.remote.model.Category
import com.example.myptv.data.remote.model.Channel
import com.example.myptv.data.remote.model.Country
import com.example.myptv.data.remote.model.Guide
import com.example.myptv.data.remote.model.Language
import com.example.myptv.data.remote.model.Region
import com.example.myptv.domain.base.UseCase
import com.example.myptv.data.remote.model.Stream
import com.example.myptv.data.remote.model.Subdivision

class GetStreamsUseCase constructor(private val repo: RepoImpl) : UseCase<List<Stream>, Any?>() {
    override suspend fun run(params: Any?): List<Stream> {
        return repo.getStreams()
    }
}
class GetBlocklistUseCase constructor(private val repo: RepoImpl) : UseCase<List<Block>, Any?>() {
    override suspend fun run(params: Any?): List<Block> {
        return repo.getBlocklist()
    }
}
class GetCategoriesUseCase constructor(private val repo: RepoImpl) : UseCase<List<Category>, Any?>() {
    override suspend fun run(params: Any?): List<Category> {
        return repo.getCategories()
    }
}
class GetCountriesUseCase constructor(private val repo: RepoImpl) : UseCase<List<Country>, Any?>() {
    override suspend fun run(params: Any?): List<Country> {
        return repo.getCountries()
    }
}
class GetGuidesUseCase constructor(private val repo: RepoImpl) : UseCase<List<Guide>, Any?>() {
    override suspend fun run(params: Any?): List<Guide> {
        return repo.getGuides()
    }
}
class GetChannelsUseCase constructor(private val repo: RepoImpl) : UseCase<List<Channel>, Any?>() {
    override suspend fun run(params: Any?): List<Channel> {
        return repo.getChannels()
    }
}
class GetLanguagesUseCase constructor(private val repo: RepoImpl) : UseCase<List<Language>, Any?>() {
    override suspend fun run(params: Any?): List<Language> {
        return repo.getLanguages()
    }
}
class GetRegionUseCase constructor(private val repo: RepoImpl) : UseCase<List<Region>, Any?>() {
    override suspend fun run(params: Any?): List<Region> {
        return repo.getRegions()
    }
}
class GetSubdivisionsUseCase constructor(private val repo: RepoImpl) : UseCase<List<Subdivision>, Any?>() {
    override suspend fun run(params: Any?): List<Subdivision> {
        return repo.getSubdivisions()
    }
}
