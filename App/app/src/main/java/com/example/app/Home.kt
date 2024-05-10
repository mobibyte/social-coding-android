package com.example.app

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

@Composable
fun Home(navController: NavHostController, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn (
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            item {
                Box(
                    modifier = Modifier
                        .padding(5.dp)
                        .scale(1.5f)
                        .size(150.dp)
                        // 2. Box for Image Shaping
                        .clip(CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = R.drawable.mobi_logo,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(CircleShape)
                    )
                }
            }

            item {
                Surface(
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                ) {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "MOBI",
                            modifier = Modifier.padding(top = 16.dp),
                            style = MaterialTheme.typography.headlineLarge
                        )
                        Text(
                            text = "Discover Magic of Making Apps!",
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.titleLarge
                        )
                    }

                }
            }

            item {
                Surface(
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp, top = 20.dp, bottom = 20.dp)
                ) {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(top = 15.dp, bottom = 15.dp)
                    ) {
                        TextButton(
                            onClick = { openUrl("https://discord.com/invite/pjjgRC7ErT", context) }
                        ) {
                            Text(
                                text = "BECOME A MOBI MEMBER! \uD83D\uDE80",
                                modifier = Modifier.padding(16.dp),
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }

            item {
                AppButtons(
                    onAboutClick = { navController.navigate(Screens.About.screen) },
                    onOfficerClick = { navController.navigate(Screens.Officers.screen) },
                    onEventsClick = { navController.navigate(Screens.Events.screen) },
                    onAppsClick = { navController.navigate(Screens.Apps.screen) },
                )
            }
        }
    }
}

@Composable
fun AppButtons(
    onAboutClick: () -> Unit,
    onOfficerClick: () -> Unit,
    onEventsClick: () -> Unit,
    onAppsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ElevatedButton(colors = ButtonDefaults.filledTonalButtonColors(), onClick = onAboutClick) {
            Text(text = "About")
        }
        ElevatedButton(colors = ButtonDefaults.filledTonalButtonColors(), onClick = onOfficerClick) {
            Text(text = "Officers")
        }
        ElevatedButton(colors = ButtonDefaults.filledTonalButtonColors(), onClick = onEventsClick){
            Text(text = "Events")
        }
        ElevatedButton(colors = ButtonDefaults.filledTonalButtonColors(), onClick = onAppsClick) {
            Text(text = "Apps")
        }
    }
}