package com.example.cinemashift2025.addiche.domain.entity

sealed class AfficheException : Exception() {
    class NetworkException(reason: String) : AfficheException(){

    }

    class UnhandledException : AfficheException() {

    }
}