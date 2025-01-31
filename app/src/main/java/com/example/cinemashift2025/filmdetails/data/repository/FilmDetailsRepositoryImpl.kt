package com.example.cinemashift2025.filmdetails.data.repository

import com.example.cinemashift2025.filmdetails.data.models.HallModel
import com.example.cinemashift2025.filmdetails.data.models.ScheduleItemModel
import com.example.cinemashift2025.filmdetails.data.models.SeanceItemModel
import com.example.cinemashift2025.shared.domain.entity.FilmItem
import com.example.cinemashift2025.filmdetails.data.network.FilmDetailsApi
import com.example.cinemashift2025.filmdetails.domain.entity.FilmDetailsException
import com.example.cinemashift2025.filmdetails.domain.entity.HallItem
import com.example.cinemashift2025.filmdetails.domain.entity.ScheduleItem
import com.example.cinemashift2025.filmdetails.domain.entity.SeanceItem
import com.example.cinemashift2025.filmdetails.domain.repository.FilmDetailsRepository
import com.example.cinemashift2025.shared.data.converters.convertToDomain

class FilmDetailsRepositoryImpl(
    private val api: FilmDetailsApi
) : FilmDetailsRepository {
    override suspend fun getFilmById(id: String): FilmItem {
        try {
            val model = api.getFilmById(id = id)

            if (model.success){
                return model.film.convertToDomain()
            }else{
                throw FilmDetailsException.NetworkException(model.reason)
            }
        }catch (e: Exception){
            throw FilmDetailsException.UnhandledException()
        }
    }

    override suspend fun getScheduleByFilmId(id: String): List<ScheduleItem> {
        try {
            val model = api.getScheduleByFilmId(id = id)

            if (model.success){
                return model.schedules.map { schedule -> schedule.convertToDomain() }
            }else{
                throw FilmDetailsException.NetworkException(model.reason)
            }
        }catch (e: Exception){
            throw FilmDetailsException.UnhandledException()
        }
    }

}

private fun ScheduleItemModel.convertToDomain(): ScheduleItem =
    ScheduleItem(
        date =date,
        seances = seances.map { seance-> seance.convertToDomain() }

    )
private fun SeanceItemModel.convertToDomain(): SeanceItem =
    SeanceItem(
        time = time,
        hall = hall.convertToDomain()
    )
private fun HallModel.convertToDomain(): HallItem =
    HallItem(
        name = name,
        places = places
    )