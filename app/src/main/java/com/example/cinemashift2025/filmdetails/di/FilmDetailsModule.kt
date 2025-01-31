package com.example.cinemashift2025.filmdetails.di

import com.example.cinemashift2025.filmdetails.data.network.FilmDetailsApi
import com.example.cinemashift2025.filmdetails.data.repository.FilmDetailsRepositoryImpl
import com.example.cinemashift2025.filmdetails.domain.repository.FilmDetailsRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import retrofit2.Retrofit
import com.example.cinemashift2025.filmdetails.domain.usecase.GetFilmDetailsUseCase
import com.example.cinemashift2025.filmdetails.domain.usecase.GetScheduleUseCase
import com.example.cinemashift2025.filmdetails.presentation.FilmDetailsViewModel
import org.koin.core.module.dsl.viewModel

val filmDetailsModule = module {
    single { get<Retrofit>().create(FilmDetailsApi::class.java) }
    single<FilmDetailsRepository> { FilmDetailsRepositoryImpl(get())}

    factoryOf(::GetFilmDetailsUseCase)
    factoryOf(::GetScheduleUseCase)

    viewModel { (filmId: String) ->
        FilmDetailsViewModel(filmId, get(), get())
    }
}