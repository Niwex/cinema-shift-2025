package com.example.cinemashift2025.addiche.data.models

import com.example.cinemashift2025.shared.data.models.FilmItemModel

data class AfficheModel(
    val success: Boolean,
    val reason: String?,
    val films: List<FilmItemModel>,
)

