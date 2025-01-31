package com.example.cinemashift2025.filmdetails.presentation

import com.example.cinemashift2025.filmdetails.domain.entity.ScheduleItem
import com.example.cinemashift2025.shared.domain.entity.FilmItem

interface DetailsState {
    data object Initial : DetailsState
    data object Loading : DetailsState
    data class Failure(val message: String?) : DetailsState
    data class Content(val film: FilmItem, val schedule: List<ScheduleItem>) : DetailsState
}