package com.example.myptv.di

import android.content.Context
import com.example.myptv.data.Repo
import com.example.myptv.data.RepoImpl
import com.example.myptv.data.local.AppDb
import com.example.myptv.data.remote.ApiInterface
import com.example.myptv.domain.GetBlocklistUseCase
import com.example.myptv.domain.GetCategoriesUseCase
import com.example.myptv.domain.GetChannelsUseCase
import com.example.myptv.domain.GetCountriesUseCase
import com.example.myptv.domain.GetGuidesUseCase
import com.example.myptv.domain.GetLanguagesUseCase
import com.example.myptv.domain.GetRegionUseCase
import com.example.myptv.domain.GetStreamsFlowUseCase
import com.example.myptv.domain.GetStreamsUseCase
import com.example.myptv.domain.GetSubdivisionsUseCase
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { createService(get()) }
    single { createRetrofit(get(), "https://iptv-org.github.io/api/") }
    single { createCache(get()) }
    single { createOkHttpClient(get()) }
}

fun createOkHttpClient(cache: Cache): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .cache(cache)
        .addInterceptor(httpLoggingInterceptor).build()
}

fun createRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun createService(retrofit: Retrofit): ApiInterface {
    return retrofit.create(ApiInterface::class.java)
}

fun createCache(context: Context): Cache = Cache(context.cacheDir, 10 * 1024 * 1024)

fun createRepoImpl(api: ApiInterface, db: AppDb): Repo = RepoImpl(api, db)

fun createGetBlocklistUseCase(repo: Repo): GetBlocklistUseCase = GetBlocklistUseCase(repo)

fun createGetCategoriesUseCase(repo: Repo): GetCategoriesUseCase = GetCategoriesUseCase(repo)

fun createGetCountriesUseCase(repo: Repo): GetCountriesUseCase = GetCountriesUseCase(repo)

fun createGetGuidesUseCase(repo: Repo): GetGuidesUseCase = GetGuidesUseCase(repo)

fun createGetChannelsUseCase(repo: Repo): GetChannelsUseCase = GetChannelsUseCase(repo)

fun createGetLanguagesUseCase(repo: Repo): GetLanguagesUseCase = GetLanguagesUseCase(repo)

fun createGetRegionUseCase(repo: Repo): GetRegionUseCase = GetRegionUseCase(repo)

fun createGetStreamsUseCase(repo: Repo): GetStreamsUseCase = GetStreamsUseCase(repo)

fun createGetStreamsFlowUseCase(repo: Repo): GetStreamsFlowUseCase = GetStreamsFlowUseCase(repo)

fun createGetSubdivisionsUseCase(repo: Repo): GetSubdivisionsUseCase =
    GetSubdivisionsUseCase(repo)
