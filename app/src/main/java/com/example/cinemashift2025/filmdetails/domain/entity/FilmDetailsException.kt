package com.example.cinemashift2025.filmdetails.domain.entity

import com.example.cinemashift2025.addiche.domain.entity.AfficheException

sealed class FilmDetailsException: Exception() {
    class NetworkException(reason: String?) : FilmDetailsException(){

    }

    class UnhandledException : FilmDetailsException() {

    }
}