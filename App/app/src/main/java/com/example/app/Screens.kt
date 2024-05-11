package com.example.app

sealed class Screens(val screen: String) {

    // main app data objects
    data object Home : Screens("home")
    data object About : Screens("about")
    data object Officers : Screens("officers")
    data object Apps : Screens("apps")

    // app screens data objects
    data object SortingAlgorithm : Screens("sortingAlgo")
}