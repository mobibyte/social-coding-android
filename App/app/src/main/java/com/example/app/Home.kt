package com.example.app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Home(navController: NavHostController, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.momo),
            contentDescription = "Momologo",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Text(
            text = "Discover Magic of Making Apps!",
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.headlineSmall
        )
        AppButtons(
            onAboutClick = { navController.navigate(Screens.About.screen) },
            onOfficerClick = { navController.navigate(Screens.Officers.screen) },
            onEventsClick = { navController.navigate(Screens.Events.screen) },
            onAppsClick = { navController.navigate(Screens.Apps.screen) },
        )
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
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = onAboutClick) {
            Text(text = "About")
        }
        Button(onClick = onOfficerClick) {
            Text(text = "Officers")
        }
        Button(onClick = onEventsClick){
            Text(text = "Events")
        }
        Button(onClick = onAppsClick) {
            Text(text = "Apps")
        }
    }
}