package com.example.cinemashift2025.filmdetails.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cinemashift2025.filmdetails.domain.usecase.GetFilmDetailsUseCase
import com.example.cinemashift2025.filmdetails.domain.usecase.GetScheduleUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FilmDetailsViewModel(
    private val filmId: String,
    private val getFilmDetailsUseCase: GetFilmDetailsUseCase,
    private val getScheduleUseCase: GetScheduleUseCase,
): ViewModel() {
    private val _state = MutableStateFlow<DetailsState>(DetailsState.Initial)
    val state: StateFlow<DetailsState> = _state

    fun loadDetails(){
        viewModelScope.launch {
            _state.value = DetailsState.Loading

            try {
                val filmDetails = getFilmDetailsUseCase(filmId)
                val schedule = getScheduleUseCase(filmId)
                _state.value = DetailsState.Content(filmDetails,schedule)
            }catch (ce: CancellationException){
                throw ce
            }catch (e: Exception){
                _state.value = DetailsState.Failure(e.message)
            }
        }
    }
}