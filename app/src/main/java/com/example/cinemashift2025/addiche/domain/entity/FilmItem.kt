package com.example.cinemashift2025.addiche.domain.entity

import java.math.BigInteger

data class FilmItem(
    val id: BigInteger,
    val name: String,
    val originalName: String,
    val description: String,
    val releaseDate: String,
    val actors: List<FilmStaf>,
    val directors: List<FilmStaf>,
    val runtime: Int,
    val ageRating: String,
    val geners: List<String>,
    val userRatings: UserRatings,
    val img: String,
    val country: Country
)

data class FilmStaf (
    val id: Int,
    val professions: String,
    val fullName: String
)

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
