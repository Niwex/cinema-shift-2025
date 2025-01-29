package com.example.cinemashift2025.addiche.data.repository

import com.example.cinemashift2025.addiche.data.models.CountryModel
import com.example.cinemashift2025.addiche.data.models.FilmItemModel
import com.example.cinemashift2025.addiche.data.models.FilmStafModel
import com.example.cinemashift2025.addiche.data.models.UserRatingsModel
import com.example.cinemashift2025.addiche.data.network.AfficheApi
import com.example.cinemashift2025.addiche.domain.entity.AfficheException
import com.example.cinemashift2025.addiche.domain.entity.Country
import com.example.cinemashift2025.addiche.domain.entity.FilmItem
import com.example.cinemashift2025.addiche.domain.entity.FilmStaf
import com.example.cinemashift2025.addiche.domain.entity.UserRatings
import com.example.cinemashift2025.addiche.domain.repository.AfficheRepository

class AfficheRepositoryImpl(
    private val afficheApi: AfficheApi
) : AfficheRepository {
    override suspend fun getAffiche(): List<FilmItem> {
        try {
            val model = afficheApi.getAffiche()
            if (model.success) {
                return model.films.map { film -> film.convert() }
            }
            else{
                throw AfficheException.NetworkException(model.reason)
            }

        }
        catch (e: Exception){
            throw AfficheException.UnhandledException()
        }

    }
}

//private fun AfficheModel.convert(): FilmItem =
//    FilmItem(  )
private fun FilmItemModel.convert(): FilmItem =
    FilmItem(id, name, originalName, description, releaseDate, actors.map { it.convert() }, directors.map { it.convert() }, runtime, ageRating, geners ,userRatings.convert(), img, country.convert())
private fun UserRatingsModel.convert(): UserRatings =
    UserRatings(kinopoisk, imdb)
private fun FilmStafModel.convert(): FilmStaf =
    FilmStaf(id,professions,fullName)
private fun CountryModel.convert(): Country =
    Country(name,code,code2,id)