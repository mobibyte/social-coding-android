package com.example.app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun Home(navController: NavHostController, modifier: Modifier = Modifier) {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn (
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            item {
                Image(
                    painter = painterResource(id = R.drawable.momo),
                    contentDescription = "Momologo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
            item {
                Text(
                    text = "Discover Magic of Making Apps!",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
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