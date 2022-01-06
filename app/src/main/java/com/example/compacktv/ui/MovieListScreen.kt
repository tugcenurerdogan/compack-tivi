package com.example.compacktv.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.compacktv.R
import com.example.compacktv.data.Movie
import com.example.compacktv.data.SampleData
import com.example.compacktv.ui.theme.LightRed

@Composable
fun MovieListScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(10.dp)
            .verticalScroll(scrollState)
    ) {
        FavIcon()
        SearchBar()
        ComingSoonTitle()
        ComingSoonList(movies = SampleData.moviesSample)
        PopularTitle()
        PopularList(movies = SampleData.moviesSample)
        TopRatedTitle()
        TopRatedList(movies = SampleData.moviesSample)
    }
}

@Composable
fun FavIcon() {
    Column(
        horizontalAlignment = Alignment.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 10.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.fav_icon),
            contentDescription = "",
            modifier = Modifier.size(36.dp, 36.dp)
        )
    }
}

@Composable
fun SearchBar() {
    val searchState = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
            .height(50.dp),
        value = searchState.value,
        onValueChange = { searchState.value = it },
        label = {
            Text(
                text = stringResource(id = R.string.search_hint),
                color = Color.DarkGray
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = Color.Gray
        ),
        shape = RoundedCornerShape(25.dp),
        trailingIcon = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.search_icon),
                    contentDescription = ""
                )
            }
        }
    )
}

@Composable
fun ComingSoonTitle() {
    Text(
        text = stringResource(R.string.coming_soon),
        style = TextStyle(
            color = LightRed,
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.ExtraBold
        )
    )
}

@Composable
fun ComingSoonList(movies: List<Movie>) {
    LazyRow {
        items(movies) { movie ->
            ComingSoonMovieCard(movie)
        }
    }
}


@Composable
fun ComingSoonMovieCard(movie: Movie) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp)
    )
    {
        Image(
            painter = painterResource(R.drawable.movie_poster),
            contentDescription = "",
            Modifier.size(250.dp, 250.dp)
        )
        Text(
            text = movie.title,
            color = Color.White,
            fontSize = 16.sp,
        )
    }
}

@Composable
fun PopularTitle() {
    Text(
        modifier = Modifier.padding(top = 15.dp),
        text = stringResource(R.string.popular),
        style = TextStyle(
            color = LightRed,
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.ExtraBold
        )
    )
}

@Composable
fun PopularList(movies: List<Movie>) {
    LazyRow {
        items(movies) { movie ->
            PopularMovieCard(movie)
        }
    }
}


@Composable
fun PopularMovieCard(movie: Movie) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    )
    {
        Image(
            painter = painterResource(R.drawable.movie_poster),
            contentDescription = "",
            Modifier.size(80.dp, 150.dp)
        )
        Text(
            text = movie.title,
            color = Color.White,
            fontSize = 12.sp,
        )
    }
}

@Composable
fun TopRatedTitle() {
    Text(
        modifier = Modifier.padding(top = 15.dp),
        text = stringResource(R.string.top_rated),
        style = TextStyle(
            color = LightRed,
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.ExtraBold
        )
    )
}

@Composable
fun TopRatedList(movies: List<Movie>) {
    LazyRow {
        items(movies) { movie ->
            TopRatedMovieCard(movie)
        }
    }
}


@Composable
fun TopRatedMovieCard(movie: Movie) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    )
    {
        Image(
            painter = painterResource(R.drawable.movie_poster),
            contentDescription = "",
            Modifier.size(80.dp, 150.dp)
        )
        Text(
            text = movie.title,
            color = Color.White,
            fontSize = 12.sp,
        )

        Row {
            Image(
                painter = painterResource(R.drawable.star_icon),
                contentDescription = "",
                modifier = Modifier.size(16.dp).padding(top = 3.dp)
            )
            Text(
                text = movie.vote_average,
                color = Color.White,
                fontSize = 12.sp,
            )
        }


    }
}
