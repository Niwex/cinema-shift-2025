package com.example.cinemashift2025.shared.data.converters

import com.example.cinemashift2025.shared.data.models.FilmItemModel
import com.example.cinemashift2025.shared.domain.entity.FilmItem

fun FilmItemModel.convertToDomain(): FilmItem =
    FilmItem(
        id = id,
        name = name,
        releaseDate = releaseDate,
        runtime = runtime,
        ageRating = ageRating,
        genres = genres.orEmpty(),
        kinopoiskRaiting = userRatings.kinopoisk.toFloatOrNull() ?: 0f,
        img = img.drop(1),
        countryName = country.name,
        description = description
    )