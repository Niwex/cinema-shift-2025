package com.example.cinemashift2025.addiche.presentation

import com.example.cinemashift2025.addiche.domain.entity.FilmItem

interface AfficheState {

    data object Initial : AfficheState
    data object Loading : AfficheState
    data class  Failure(val messege: String?) : AfficheState
    data class  Content(val films: List<FilmItem>) : AfficheState
}