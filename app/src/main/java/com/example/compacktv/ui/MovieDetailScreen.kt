package com.example.compacktv.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compacktv.R
import com.example.compacktv.data.Movie
import com.example.compacktv.data.SampleData

@Composable
fun MovieDetailScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        MoviePoster()
        MovieName(movie = SampleData.moviesSample.get(0))
        MovieOverview(movie = SampleData.moviesSample.get(0))
    }
}

@Composable
fun MoviePoster() {
    Image(
        painter = painterResource(id = R.drawable.movie_poster),
        contentDescription = "",
        modifier = Modifier
            .fillMaxWidth()
            .size(400.dp)
    )
}

@Composable
fun MovieName(movie: Movie) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = movie.title,
            color = Color.White,
            style = TextStyle(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp
            )
        )
    }
}

@Composable
fun MovieOverview(movie: Movie) {
    Text(
        text = movie.overview,
        color = Color.Gray
    )
}