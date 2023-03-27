package com.example.section16_movieapp.screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.section16_movieapp.model.getMovies

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailsScreen(navController: NavController, movieId: String?) {
    val movies = getMovies().filter { it.id == movieId }
    val movie = movies[0]
    Scaffold(topBar = {
        TopAppBar(
            elevation = 5.dp
        ) {
            Button(onClick = { navController.popBackStack() }) {
                Text(text = "Back")
            }
            Text(text = movie.title)
        }
    }) {
        Column() {
            Text(text = "Genre: ${movie.genre}", style = MaterialTheme.typography.caption)
            Text(text = "Released: ${movie.year}", style = MaterialTheme.typography.caption)
            Text(text = "Plot: ${movie.plot}", style = MaterialTheme.typography.caption)
            Text(text = "Actors: ${movie.actors}", style = MaterialTheme.typography.caption)
            Text(text = "Rating: ${movie.rating}", style = MaterialTheme.typography.caption)
        }
    }
}