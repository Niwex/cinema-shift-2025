package com.example.cinemashift2025.addiche.domain.repository

import com.example.cinemashift2025.addiche.domain.entity.FilmItem

interface AfficheRepository {
    suspend fun getAffiche(): List<FilmItem>
}