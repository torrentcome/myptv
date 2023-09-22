package com.example.myptv.di

import com.example.myptv.data.ApiInterface
import com.example.myptv.data.RepoImpl
import com.example.myptv.domain.GetStreamsUseCase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { createService(get()) }
    single { createRetrofit(get(), "https://iptv-org.github.io/api") }
    single { createOkHttpClient() }
}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.SECONDS)
        .readTimeout(5, TimeUnit.SECONDS)
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