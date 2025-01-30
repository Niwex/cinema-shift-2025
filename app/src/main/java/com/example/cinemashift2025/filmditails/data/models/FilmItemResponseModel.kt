package com.example.cinemashift2025.filmditails.data.models

import com.example.cinemashift2025.addiche.data.models.FilmItemModel

data class FilmItemResponseModel(
    val success: String,
    val reason: String?,
    val film: FilmItemModel
)
