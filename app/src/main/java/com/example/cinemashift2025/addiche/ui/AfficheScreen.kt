package com.example.cinemashift2025.addiche.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.cinemashift2025.addiche.presentation.AfficheViewModel
import androidx.compose.material3.Text
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.cinemashift2025.R
import com.example.cinemashift2025.addiche.presentation.AfficheState


@Composable
fun AfficheScreen(
    afficheViewModel: AfficheViewModel,
    onItemSelected: (filmID: String)-> Unit,
) {

    val afficheState by afficheViewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        afficheViewModel.loadAffiche()
    }

    AfficheStateStateless(afficheState, afficheViewModel, onItemSelected)
}


@Composable
fun AfficheStateStateless(state: AfficheState, afficheViewModel: AfficheViewModel, onItemSelected: (filmID: String)-> Unit) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 12.dp),
            text = stringResource(id = R.string.affiche_title),
            style = MaterialTheme.typography.titleLarge,
        )

        when (state) {
            is AfficheState.Initial,
            is AfficheState.Loading -> LoadingComponent()
            is AfficheState.Failure -> ErrorComponent(
                    message = state.messege?: stringResource(id = R.string.error_unknown_error),
                    onRetry = { afficheViewModel.loadAffiche()}
                
                )
            is AfficheState.Content -> ContentComponent(
                films = state.films,
                onItemClicked = onItemSelected,
                )
        }

    }

}