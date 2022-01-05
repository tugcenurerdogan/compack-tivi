package com.example.compacktv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compacktv.ui.LoginScreen
import com.example.compacktv.ui.MovieDetailScreen
import com.example.compacktv.ui.MovieListScreen
import com.example.compacktv.ui.theme.CompackTVTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompackTVTheme {
                Surface(
                    color = Color.Black,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = "login") {
                        composable("login") { LoginScreen(navController) }
                        composable("movieList") { MovieListScreen(navController) }
                        composable("movieDetail") { MovieDetailScreen() }
                    }
                }
            }
        }
    }
}
