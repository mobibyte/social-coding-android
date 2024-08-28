package com.example.SocialCoding.AppScreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.mobibyte.app.R

@Composable
fun AppTemp(title: String, img: Int, navController: NavHostController, routeToScreen: String) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable { navController.navigate(route = routeToScreen) }
    ) {

        AsyncImage(
            model = img,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .clip(CircleShape)
        )

        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .padding(4.dp)
        )
    }
}

//when creating a title please stick to 17 chars, it make the grid look nice :>

@Composable
fun Apps(navController: NavHostController) {
    LazyVerticalGrid (
        columns = GridCells.Adaptive(minSize = 110.dp),
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        //Sorting Algorithm App - Betim Hodza
        item {
            AppTemp(title = "Sorting Algorithm", img = R.drawable.mobi_logo, navController, "sortingAlgo")
        }
        //Falling Cube Animation - Betim Hodza
        item {
            AppTemp(title = "Falling Square", img = R.drawable.fallingsquare, navController, "fallingSquareAnim")
        }

    }
}