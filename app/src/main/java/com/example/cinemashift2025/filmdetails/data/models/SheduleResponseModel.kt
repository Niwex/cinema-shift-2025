package com.example.cinemashift2025.filmdetails.data.models

data class ScheduleResponseModel(
    val success: Boolean,
    val reason: String,
    val schedules: List<ScheduleItemModel>
)
