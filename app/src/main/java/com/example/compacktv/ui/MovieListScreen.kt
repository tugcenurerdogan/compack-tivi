package com.example.compacktv.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun MovieListScreen(navController: NavController) {
    Row {
        Text(
            text = "Movie List Screen",
            color = Color.White
        )
        Button(onClick = { navController.navigate("movieDetail") }) {
            Text(text = "NEXT")
        }
    }
}