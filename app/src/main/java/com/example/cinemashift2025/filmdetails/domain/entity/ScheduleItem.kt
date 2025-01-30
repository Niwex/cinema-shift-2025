package com.example.cinemashift2025.filmdetails.domain.entity

data class ScheduleItem (
    val date: String,
    val seances: List<SeanceItem>
)

data class SeanceItem (
    val time: String,
    val hall: HallItem,
)

data class HallItem(
    val name: String,
    val places: List<Any>?
)
