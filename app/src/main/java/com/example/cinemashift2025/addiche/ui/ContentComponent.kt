package com.example.cinemashift2025.addiche.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.example.cinemashift2025.R
import com.example.cinemashift2025.addiche.domain.entity.FilmItem


@Composable
fun ContentComponent(films: List<FilmItem>, onItemClicked:(itemID: String) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(films) { item ->
            FilmItemComponent(
                item,
                onItemClicked = {onItemClicked(item.id)}
            )
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun FilmItemComponent(item: FilmItem, onItemClicked:(itemID: String) -> Unit) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        FilmImagePosterCard(
            img = item.img,
            genre = item.genres[0],
            country = item.countryName,
            releaseDate = item.releaseDate,
            name = item.name,
            ageRating = item.ageRating,
            kinopoiskRating = item.kinopoiskRaiting
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(56.dp),
            shape = RoundedCornerShape(16.dp),

            onClick = { onItemClicked(item.id) }
        ) {
            Text(text = stringResource(id = R.string.ditails))
        }
    }
}
