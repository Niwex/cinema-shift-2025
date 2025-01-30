package com.example.cinemashift2025

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cinemashift2025.addiche.AfficheRoute
import com.example.cinemashift2025.addiche.ui.AfficheScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Surface {
        NavHost(navController = navController, startDestination = AfficheRoute) {
            composable<AfficheRoute> {
                AfficheScreen(
                    afficheViewModel =  koinViewModel(),
                    onItemSelected = {
//                        navController.navigate(DetailsRoute(loanId = it))
                                     },
                )
            }
//            composable<DetailsRoute> {
//                val destination = it.toRoute<DetailsRoute>()
//                DetailsScreen(
//                    viewModel = koinViewModel { parametersOf(destination.loanId) },
//                )
//            }
        }
    }
}