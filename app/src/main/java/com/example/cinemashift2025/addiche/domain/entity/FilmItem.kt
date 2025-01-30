package com.example.cinemashift2025.addiche.domain.entity

data class FilmItem(
    val id: String,
    val name: String,
    val releaseDate: String,
    val runtime: Int,
    val ageRating: String,
    val genres: List<String> = listOf(),
    val kinopoiskRaiting: Float,
    val img: String,
    val countryName: String
)

