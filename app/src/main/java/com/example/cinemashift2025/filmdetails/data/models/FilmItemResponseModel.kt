package com.example.cinemashift2025.filmdetails.data.models

import com.example.cinemashift2025.shared.data.models.FilmItemModel

data class FilmItemResponseModel(
    val success: Boolean,
    val reason: String?,
    val film: FilmItemModel
)
