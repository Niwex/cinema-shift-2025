package com.example.cinemashift2025.filmdetails.domain.usecase

import com.example.cinemashift2025.filmdetails.domain.entity.ScheduleItem
import com.example.cinemashift2025.filmdetails.domain.repository.FilmDetailsRepository

class GetScheduleUseCase(
    private val repository: FilmDetailsRepository
) {
    suspend operator fun invoke(filmId: String): List<ScheduleItem> =
        repository.getScheduleByFilmId(id = filmId)
}