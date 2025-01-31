package com.example.cinemashift2025.addiche.domain.usecase

import com.example.cinemashift2025.shared.domain.entity.FilmItem
import com.example.cinemashift2025.addiche.domain.repository.AfficheRepository

class GetFilmItemsUseCase(
    private val repository: AfficheRepository
) {
    suspend operator fun invoke(): List<FilmItem> =
        repository.getAffiche()
}