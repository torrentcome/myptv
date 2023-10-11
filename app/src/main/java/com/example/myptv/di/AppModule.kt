package com.example.myptv.di

import com.example.myptv.presentation.StreamsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { createRepoImpl(get(), get()) }

    // network UseCases
    single { createGetStreamsUseCase(get()) }
    single { createGetStreamsFlowUseCase(get()) }
    single { createGetBlocklistUseCase(get()) }
    single { createGetCategoriesUseCase(get()) }
    single { createGetCountriesUseCase(get()) }
    single { createGetGuidesUseCase(get()) }
    single { createGetChannelsUseCase(get()) }
    single { createGetLanguagesUseCase(get()) }
    single { createGetRegionUseCase(get()) }
    single { createGetSubdivisionsUseCase(get()) }

    // presentation VM
    viewModel { StreamsViewModel(get()) }
}
