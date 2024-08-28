package com.mobibyte.SocialCoding.AppScreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

//when creating a new app, you can use this template to start
//note dont actually call this function in your apps
@Composable
fun Template(navController: NavHostController) {
    //vals and vars go here
    /*e.g.*/ val Title = "template app"

    //display info here
    LazyColumn (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(text = Title)
        }
    }
}