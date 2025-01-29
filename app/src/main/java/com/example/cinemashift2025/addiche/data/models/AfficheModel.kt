package com.example.cinemashift2025.addiche.data.models

data class AfficheModel(
    val success: Boolean,
    val reason: String,
    val films: List<FilmItemModel>,
)

