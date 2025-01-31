package com.example.cinemashift2025

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.cinemashift2025.addiche.AfficheRoute
import com.example.cinemashift2025.addiche.ui.AfficheScreen
import com.example.cinemashift2025.filmdetails.FilmDetailsRoute
import com.example.cinemashift2025.filmdetails.ui.FilmDetailsScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Surface {
        NavHost(navController = navController, startDestination = AfficheRoute) {
            composable<AfficheRoute> {
                AfficheScreen(
                    afficheViewModel =  koinViewModel(),
                    onItemSelected = {
                        navController.navigate(FilmDetailsRoute(filmId = it))
                                     },
                )
            }
            composable<FilmDetailsRoute> {
                val destination = it.toRoute<FilmDetailsRoute>()
                FilmDetailsScreen(
                    filmDetailsViewModel = koinViewModel { parametersOf(destination.filmId) },
                )
            }
        }
    }
}