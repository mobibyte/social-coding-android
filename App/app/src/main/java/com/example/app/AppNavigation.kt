package com.example.app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.app.AboutScreen
import com.example.app.AppsScreen
import com.example.app.EventsScreen
import com.example.app.Greeting
import com.example.app.OfficersScreen
import com.example.app.Screen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            Greeting(navController = navController)
        }
        composable(route = Screen.About.route) {
            AboutScreen()
        }
        composable(route = Screen.Officers.route) {
            OfficersScreen()
        }
        composable(route = Screen.Events.route) {
            EventsScreen()
        }
        composable(route = Screen.Apps.route) {
            AppsScreen()
        }
    }
}