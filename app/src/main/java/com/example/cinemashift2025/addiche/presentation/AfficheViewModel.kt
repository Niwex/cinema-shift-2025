package com.example.cinemashift2025.addiche.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinemashift2025.addiche.domain.usecase.GetFilmItemsUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AfficheViewModel(
    private val getAfficheUseCase: GetFilmItemsUseCase,
): ViewModel() {

    private val _state = MutableStateFlow<AfficheState>(AfficheState.Initial)
    val state: StateFlow<AfficheState> = _state

    fun loadAffiche() {
        viewModelScope.launch {

            _state.value = AfficheState.Loading

            try {
                val films = getAfficheUseCase()
                _state.value = AfficheState.Content(films)
            }
            catch (ce: CancellationException){
                throw ce
            }catch (ex: Exception){
                _state.value = AfficheState.Failure(ex.localizedMessage.orEmpty())
            }

        }
    }
}