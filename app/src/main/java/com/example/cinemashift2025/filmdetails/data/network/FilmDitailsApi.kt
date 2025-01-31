package com.example.cinemashift2025.filmdetails.data.network

import com.example.cinemashift2025.filmdetails.data.models.FilmItemResponseModel
import com.example.cinemashift2025.filmdetails.data.models.ScheduleResponseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmDetailsApi {

    @GET("film/{id}")
    suspend fun getFilmById(@Path("id") id: String): FilmItemResponseModel

    @GET("film/{id}/schedule")
    suspend fun getScheduleByFilmId(@Path("id") id: String): ScheduleResponseModel
}