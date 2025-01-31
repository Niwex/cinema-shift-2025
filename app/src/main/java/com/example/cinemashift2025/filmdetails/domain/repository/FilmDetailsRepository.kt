package com.example.cinemashift2025.filmdetails.domain.repository

import com.example.cinemashift2025.shared.domain.entity.FilmItem
import com.example.cinemashift2025.filmdetails.domain.entity.ScheduleItem

interface FilmDetailsRepository {

    suspend fun getFilmById(id: String): FilmItem

    suspend fun getScheduleByFilmId(id: String): List<ScheduleItem>
}