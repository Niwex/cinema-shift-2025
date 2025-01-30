package com.example.cinemashift2025.filmditails.data.models

data class ScheduleItemModel (
    val date: String,
    val seances: List<SeanceItemModel>
)

data class SeanceItemModel (
    val time: String,
    val hall: HallModel
)

data class HallModel (
    val name : String,
    val places: List<Any>?
)
