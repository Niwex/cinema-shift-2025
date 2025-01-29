package com.example.cinemashift2025.data.model

import java.math.BigInteger

data class FilmItemModel(
    val id: BigInteger,
    val name: String,
    val originalName: String,
    val description: String,
    val releaseDate: String,
    val actors: Array<FilmStafModel>,
    val directors: Array<FilmStafModel>,
    val runtime: Int,
    val ageRating: AgeRatings,
    val geners: Array<String>,
    val userRatings: UserRatings,
    val img: String,
    val country: Country

)

enum class AgeRatings {
    G,
    PG,
    PG13,
    R,
    NC17
}

data class UserRatings(
    val kinopoisk: String,
    val imdb: String,
)

data class Country(
    val name: String,
    val code: String,
    val code2: String,
    val id: Int
)
