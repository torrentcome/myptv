package com.example.myptv.di

import com.example.myptv.presentation.StreamsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { createRepoImpl(get()) }
    single { createGetStreamsUseCase(get()) }

    viewModel { StreamsViewModel(get()) }
}
