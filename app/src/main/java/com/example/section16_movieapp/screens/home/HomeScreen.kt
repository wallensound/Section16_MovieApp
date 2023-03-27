package com.example.section16_movieapp.ui.theme.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.section16_movieapp.model.Movie
import com.example.section16_movieapp.model.getMovies
import com.example.section16_movieapp.naviagation.MovieScreens
import com.example.section16_movieapp.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(
            elevation = 5.dp
        ) {
            Text(text = "Movies")
        }
    }) {
        MyContent(navController = navController)
    }
}

@Composable
fun MyContent(
    navController: NavController,
    movieList: List<Movie> = getMovies()
) {

    LazyColumn(modifier = Modifier.padding(12.dp)) {
        items(items = movieList) {
            MovieRow(movie = it) { movie ->
                navController.navigate(MovieScreens.DetailsScreen.name+"/$movie")
            }
        }
    }
}