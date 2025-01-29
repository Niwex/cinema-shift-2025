package com.example.cinemashift2025.addiche.data.network

import com.example.cinemashift2025.addiche.data.models.AfficheModel
import retrofit2.http.GET

interface AfficheApi {

    @GET("today")
    suspend fun getAffiche(): AfficheModel
}