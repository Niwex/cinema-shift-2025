package com.example.cinemashift2025.addiche.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.cinemashift2025.R
import com.example.cinemashift2025.di.BASE_URL_POSTER

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun FilmImagePosterCard(
    img: String,
    genre: String,
    country: String,
    releaseDate: String,
    name: String,
    ageRating: String,
    kinopoiskRating: Float,
) {
    val color = MaterialTheme.colorScheme.secondary

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeight(300.dp)
            .clip(RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.BottomEnd
    ) {
        GlideImage(
            model = BASE_URL_POSTER + img,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Box(modifier = Modifier.background(color = color)) {
            Text(text = "$genre\n$country, $releaseDate")
        }
    }

    Column {
        Text(text = "$name ($ageRating)", fontSize=20.sp, fontWeight = FontWeight.Bold)
        Text(text = stringResource(id = R.string.film_title), fontSize = 14.sp, )

        Text(text = "${stringResource(id = R.string.kinopoisk)} - $kinopoiskRating", fontSize = 14.sp, )

    }

}
