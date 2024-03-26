package com.example.app

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object About : Screen("about")
    object Officers : Screen("officers")
    object Events : Screen("events")
    object Apps : Screen("apps")
}