package com.example.cinemashift2025.shared.data.models

data class FilmItemModel(
    val id: String,
    val name: String,
    val originalName: String,
    val description: String,
    val releaseDate: String,
    val actors: List<FilmStaffModel>,
    val directors: List<FilmStaffModel>,
    val runtime: Int,
    val ageRating: String,
    val genres: List<String>?,
    val userRatings: UserRatingsModel,
    val img: String,
    val country: CountryModel
)

data class UserRatingsModel(
    val kinopoisk: String,
    val imdb: String,
)

data class CountryModel(
    val name: String,
    val code: String,
    val code2: String,
    val id: Int
)

