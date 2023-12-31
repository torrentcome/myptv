package com.example.myptv.data

import android.util.Log
import com.example.myptv.data.local.AppDb
import com.example.myptv.data.map.Mapper
import com.example.myptv.data.remote.ApiInterface
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class RepoImpl(private val api: ApiInterface, private val db: AppDb) : Repo {

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
        return withContext(Dispatchers.IO) {
            val streams = api.getStreams()
            streams.forEach {
                db.streamDao.insert(Mapper.map(it))
            }
            return@withContext db.streamDao.loadAll().map { Mapper.map(it) }
        }
    }

    override suspend fun getStreamsFlow(): Flow<ResultData<MutableList<Stream>>> = flow {
        emit(ResultData.Loading)
        Log.i("myptv", "Loading")
        val count = db.streamDao.getCount()
        if (count > 20) { // TODO: when to refresh data ? i don't want to hit the api everyday
            Log.i("myptv", "db.streamDao.getCount() = $count")
            val toMutableList = db.streamDao.load("https://ythlsgo%").map { local ->
                Mapper.map(local)
            }.toMutableList()
            emit(ResultData.Success(toMutableList))
        } else {
            val response = api.getStreamsFlow()
            val result = response.body()
            if (result != null && response.isSuccessful) {
                val toMutableList: MutableList<Stream> = result
                    .filter {// TODO : have a worker-bg who will ping url 1 by 1 delete when not responding
                        it.url.isNotEmpty()
                                && it.url.startsWith("https")
                                && it.url.endsWith(".m3u8")
                                && !it.channel.isNullOrEmpty()
                    }
                    .map { remote -> Mapper.map(remote) }
                    .map { local ->
                        db.streamDao.insert(local)
                        val domain = Mapper.map(local)
                        domain
                    }
                    .toMutableList()
                emit(ResultData.Success(toMutableList))
            } else {
                emit(ResultData.Message(response.message()))
            }
        }
    }.catch {
        emit(ResultData.Error(it))
    }.flowOn(Dispatchers.IO)
}