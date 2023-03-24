package com.example.section16_movieapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.section16_movieapp.ui.theme.Section16_MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyContent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    Section16_MovieAppTheme {
        Scaffold(topBar = {
            TopAppBar(
                elevation = 5.dp
            ) {
                Text(text = "Movies")
            }
        }) {
            content()
        }
    }
}

@Composable
fun MyContent(
    movieList: List<String> = listOf(
        "Avatar",
        "300",
        "Room",
        "Harry Potter",
        "Avatar",
        "300",
        "Room",
        "Harry Potter",
        "Avatar",
        "300",
        "Room",
        "Harry Potter"
    )
) {

    LazyColumn(modifier = Modifier.padding(12.dp)) {
        items(items = movieList) {
            MovieRow(movie = it) {movie ->
                Log.d("Movie", "MyContent: $movie")
            }
        }
    }
}

@Composable
fun MovieRow(movie: String, onItemClick: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .height(100.dp)
            .clickable {
                onItemClick(movie)
            },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                modifier = Modifier.size(100.dp),
                imageVector = Icons.Default.AccountBox,
                contentDescription = "Movie Picture"
            )
            Text(text = movie)
        }
    }
}