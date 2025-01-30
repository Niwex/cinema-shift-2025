package com.example.cinemashift2025.addiche.di

import com.example.cinemashift2025.addiche.data.network.AfficheApi
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import com.example.cinemashift2025.addiche.domain.usecase.GetFilmItemsUseCase
import com.example.cinemashift2025.addiche.domain.repository.AfficheRepository
import com.example.cinemashift2025.addiche.presentation.AfficheViewModel
import com.example.cinemashift2025.addiche.data.repository.AfficheRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel

val afficheModule = module {
    single { get<Retrofit>().create(AfficheApi::class.java) }

    single<AfficheRepository> { AfficheRepositoryImpl(get()) }

    factoryOf(::GetFilmItemsUseCase)

    viewModel { AfficheViewModel(get())}
}