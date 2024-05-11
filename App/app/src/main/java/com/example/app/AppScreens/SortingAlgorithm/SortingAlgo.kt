package com.example.app.AppScreens.SortingAlgorithm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

// BubbleSort Algorithm
fun bubbleSort(list: List<Int>): Sequence<List<Int>> = sequence {
    val n = list.size
    var sortedList = list.toMutableList()

    for (i in 0 until n - 1) {
        for (j in 0 until n - i - 1) {
            if (sortedList[j] > sortedList[j + 1]) {
                // Swap sortedList[j] and sortedList[j + 1]
                val temp = sortedList[j]
                sortedList[j] = sortedList[j + 1]
                sortedList[j + 1] = temp
            }
            // Yield the current state of the list for visualization
            yield(sortedList.toList())
        }
    }
    // Yield the final sorted list
    yield(sortedList.toList())
}

// Visualize the sorting process
@Composable
fun VisualizeSorting(list: List<Int>, i: Int, j: Int) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(list.size) { index ->
            Text(
                text = list[index].toString(),
                modifier = Modifier.padding(8.dp),
                color = if (index == i || index == j) {
                    Color.Red
                } else {
                    Color.Blue
                }
            )
        }

    }
}

@Composable
fun SortingAlgo(navController: NavHostController) {
    // Define a mutable state to hold the list of items
    var numbers by remember { mutableStateOf(listOf(5, 3, 8, 1, 9)) }
    var sortedStates by remember { mutableStateOf<List<List<Int>>>(emptyList()) }
    var currentIndex by remember { mutableStateOf(0) }

    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (sortedStates.isEmpty()) {
            Button(
                onClick = { sortedStates = bubbleSort(numbers).toList() },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Sort")
            }
        } else {
            Button(
                onClick = { currentIndex = (currentIndex + 1) % sortedStates.size },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = if (currentIndex == sortedStates.lastIndex) "Sorted!" else "Next Step")
            }
        }

        VisualizeSorting(sortedStates.getOrElse(currentIndex) { numbers }, -1, -1)
    }
}