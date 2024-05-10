package com.example.app

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage


@Composable
fun AboutTemplate(title: String, description: String, img: Int) {
    Surface(
        color = MaterialTheme.colorScheme.outlineVariant,
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp)
    ) {
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(10.dp)
            )

            Divider(thickness = 3.dp, color = MaterialTheme.colorScheme.outline)

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(10.dp)
            )

            AsyncImage(
                model = img,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun About(navController: NavHostController) {
        LazyColumn (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //about us!
            item {
                AboutTemplate(
                    title = "About Us",
                    description = "We're Mobi, an app development club just for you. " +
                            "We're a community of developer friends that are here to help you " +
                            "code and have fun! ",
                    img = R.drawable.mobi_about_us
                )
            }
            //membership
            item {
                AboutTemplate(
                    title = "MemberShip",
                    description = "All of our events are completely free, " +
                        "so membership is free. We want to make sure no one is excluded in our events. " +
                        "If you would like to additionally support Mobi and its events, you can purchase a membership" +
                        " package for a tshirt.",
                    img = R.drawable.membership_photo
                )
            }
            //philosophy
            item {
                AboutTemplate(
                    title = "Philosophy",
                    description = "We’re a community-first group. You don’t have to be an engineer " +
                            "to code, and you don’t have to be super smart! Everyone can build! " +
                            "We’re just here to help you make it real. ",
                    img = R.drawable.philosophy_photo
                )
            }
            //events
            item {
                AboutTemplate(
                    title = "Events",
                    description = "We have bunch of cool events happening throughout the semester, " +
                            "one of them being social coding. Bring your friends! You can participate " +
                            "in our events just by coming in person! ",
                    img = R.drawable.events_photo
                )
            }
        }
}
