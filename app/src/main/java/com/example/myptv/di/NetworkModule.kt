package com.example.myptv.di

import com.example.myptv.data.remote.ApiInterface
import com.example.myptv.data.RepoImpl
import com.example.myptv.domain.GetBlocklistUseCase
import com.example.myptv.domain.GetCategoriesUseCase
import com.example.myptv.domain.GetChannelsUseCase
import com.example.myptv.domain.GetCountriesUseCase
import com.example.myptv.domain.GetGuidesUseCase
import com.example.myptv.domain.GetLanguagesUseCase
import com.example.myptv.domain.GetRegionUseCase
import com.example.myptv.domain.GetStreamsUseCase
import com.example.myptv.domain.GetSubdivisionsUseCase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { createService(get()) }
    single { createRetrofit(get(), "https://iptv-org.github.io/api/") }
    single { createOkHttpClient() }
}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
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

fun createRepoImpl(api: ApiInterface): RepoImpl {
    return RepoImpl(api)
}

fun createGetStreamsUseCase(repo: RepoImpl): GetStreamsUseCase {
    return GetStreamsUseCase(repo)
}

fun createGetBlocklistUseCase(repo: RepoImpl): GetBlocklistUseCase {
    return GetBlocklistUseCase(repo)
}

fun createGetCategoriesUseCase(repo: RepoImpl): GetCategoriesUseCase {
    return GetCategoriesUseCase(repo)
}

fun createGetCountriesUseCase(repo: RepoImpl): GetCountriesUseCase {
    return GetCountriesUseCase(repo)
}

fun createGetGuidesUseCase(repo: RepoImpl): GetGuidesUseCase {
    return GetGuidesUseCase(repo)
}

fun createGetChannelsUseCase(repo: RepoImpl): GetChannelsUseCase {
    return GetChannelsUseCase(repo)
}

fun createGetLanguagesUseCase(repo: RepoImpl): GetLanguagesUseCase {
    return GetLanguagesUseCase(repo)
}

fun createGetRegionUseCase(repo: RepoImpl): GetRegionUseCase {
    return GetRegionUseCase(repo)
}

fun createGetSubdivisionsUseCase(repo: RepoImpl): GetSubdivisionsUseCase {
    return GetSubdivisionsUseCase(repo)
}