package com.example.cinemashift2025.addiche.data.repository

import android.util.Log
import com.example.cinemashift2025.shared.data.models.FilmItemModel
import com.example.cinemashift2025.addiche.data.network.AfficheApi
import com.example.cinemashift2025.addiche.domain.entity.AfficheException
import com.example.cinemashift2025.shared.domain.entity.FilmItem
import com.example.cinemashift2025.addiche.domain.repository.AfficheRepository
import com.example.cinemashift2025.shared.data.converters.convertToDomain

class AfficheRepositoryImpl(
    private val afficheApi: AfficheApi
) : AfficheRepository {
    override suspend fun getAffiche(): List<FilmItem> {
        try {
            val model = afficheApi.getAffiche()
            if (model.success) {
                val mapedModel = model.films.map { film -> film.convertToDomain() }
                return mapedModel
            }
            else{
                throw AfficheException.NetworkException(model.reason)
            }

        }
        catch (e: Exception){
            Log.e("mytag", "getAffiche: ${e.message}", )
            throw AfficheException.UnhandledException()
        }

    }
}
