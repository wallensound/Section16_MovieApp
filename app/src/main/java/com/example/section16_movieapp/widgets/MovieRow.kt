package com.example.section16_movieapp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.section16_movieapp.model.Movie

@Composable
fun MovieRow(movie: Movie, onItemClick: (String) -> Unit) {
    val expanded = remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable {
                onItemClick(movie.id)
            },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(12.dp)
        ) {
            Surface(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(16.dp))
                    .size(100.dp)
            ) {
                AsyncImage(
                    model = movie.images[0],
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.size(width = 16.dp, height = 1.dp))
            Column() {
                Text(text = movie.title, style = MaterialTheme.typography.h6)
                Text(text = "Genre: ${movie.genre}", style = MaterialTheme.typography.caption)
                Text(text = "Released: ${movie.year}", style = MaterialTheme.typography.caption)
                AnimatedVisibility(visible = expanded.value) {
                    Column() {
                        Text(text = "Plot: ${movie.plot}", style = MaterialTheme.typography.caption)
                    }
                }
                Icon(
                    imageVector =
                    if (expanded.value) {
                        Icons.Filled.KeyboardArrowUp
                    } else {
                        Icons.Filled.KeyboardArrowDown
                    },
                    contentDescription = "",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable { expanded.value = !expanded.value })
            }
        }
    }
}