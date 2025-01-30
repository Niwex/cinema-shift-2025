package com.example.cinemashift2025.addiche.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
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

@Composable
private fun FilmItemComponent(item: FilmItem, onItemClicked:(itemID: String) -> Unit) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Column {
            if (item.genres.isNotEmpty()){
                Text(text = item.genres[0])
            }
            Text(text = "${item.countryName}, ${item.releaseDate}")
            Text(text = item.name +"("+item.ageRating +")")
            Text(text = stringResource(id = R.string.film_title))
            Text(text = "kinopoisk: " + item.kinopoiskRaiting)
        }
    }
}
