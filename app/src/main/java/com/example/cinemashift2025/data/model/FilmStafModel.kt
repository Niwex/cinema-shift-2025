package com.example.cinemashift2025.data.model

data class FilmStafModel (
    val id: Int,
    val professions: Profession,
    val fullName: String
)

enum class Profession {
    ACTOR,
    DIRECTOR
}
