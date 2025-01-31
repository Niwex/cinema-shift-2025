package com.example.cinemashift2025.filmdetails.domain.usecase

import com.example.cinemashift2025.filmdetails.domain.repository.FilmDetailsRepository
import com.example.cinemashift2025.shared.domain.entity.FilmItem

class GetFilmDetailsUseCase(
    private val repository: FilmDetailsRepository
) {
    suspend operator fun invoke(filmId: String): FilmItem =
        repository.getFilmById(id = filmId)
}