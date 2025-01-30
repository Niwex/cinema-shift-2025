package com.example.cinemashift2025.filmditails.data.models

data class SheduleResponseModel(
    val success: String,
    val reason: String,
    val shedules: List<ScheduleItemModel>
)
