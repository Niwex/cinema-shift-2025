package com.example.cinemashift2025.addiche.data.models

import com.example.cinemashift2025.addiche.domain.entity.FilmItem
import com.example.cinemashift2025.addiche.domain.entity.UserRatings
import com.example.cinemashift2025.addiche.domain.entity.Country
//import com.example.cinemashift2025.addiche.domain.entity.

import java.math.BigInteger

data class FilmItemModel(
    val id: Long,
    val name: String,
    val originalName: String,
    val description: String,
    val releaseDate: String,
    val actors: List<FilmStafModel>,
    val directors: List<FilmStafModel>,
    val runtime: Int,
    val ageRating: String,
    val geners: List<String>,
    val userRatings: UserRatingsModel,
    val img: String,
    val country: CountryModel
)

//enum class AgeRatings {
//    G,
//    PG,
//    PG13,
//    R,
//    NC17
//}

data class UserRatingsModel(
    val kinopoisk: String,
    val imdb: String,
)

data class CountryModel(
    val name: String,
    val code: String,
    val code2: String,
    val id: Long
)

