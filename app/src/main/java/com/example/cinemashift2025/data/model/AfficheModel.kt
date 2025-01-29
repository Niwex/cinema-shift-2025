package com.example.cinemashift2025.data.model

data class AfficheModel(
    val success: Boolean,
    val reason: String,
    val films: Array<FilmItemModel>,
)