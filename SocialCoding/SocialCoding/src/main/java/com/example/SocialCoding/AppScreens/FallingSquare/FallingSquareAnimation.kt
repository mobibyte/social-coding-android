package com.mobibyte.SocialCoding.AppScreens.FallingSquare

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.navigation.NavHostController

@Composable
fun FallingSquare(duration: Int, colorIdx: Int, xOffset: Int) {
    //colors to animate
    val colors = listOf(
        Color(0xFF0BE3D1),
        Color(0xFFB7224B),
        Color(0xFF0EBD47),
        Color(0xFFFF9F3A)
    )

    var i = colorIdx

    // infinite animation cycle
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val animatedColor by infiniteTransition.animateColor(
        initialValue = colors.elementAt(i),
        targetValue = colors.elementAt(--i),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 4000),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )
    val fallingAnimation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = duration, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )

    val translation = fallingAnimation * 800.dp
    val rotation = fallingAnimation * 480

    //box falling
    Box (
        modifier = Modifier.offset(y = (-250).dp, x = xOffset.dp)
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .offset(y = translation, x = (-55).dp)
                .rotate(degrees = rotation)
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(animatedColor)
//                .border(border, Color.Gray)
            ){
            }
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .rotate(degrees = rotation - 1500)
                    .alpha(alpha = 0.8F)
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(animatedColor)
//                    .border(border, Color.Gray)
                ){

                }
            }
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .rotate(degrees = rotation - 2800)
                    .alpha(alpha = 0.4F)
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(animatedColor)
//                    .border(border, Color.Gray)
                ){

                }
            }
        }
    }
}

data class Square(
    val xOffset: Int,
    val colorIndex: Int
)

@Composable
fun FallingSquareApp(navController: NavHostController) {
    var squares by remember { mutableStateOf(emptyList<Square>()) }
    val maxNumSquare = 5

    //display info here
    LazyColumn (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "Falling Square Animation",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineMedium
                )
        }
        
        item {
            FilledTonalButton(
                onClick = {
                    if (squares.size <= maxNumSquare) {
                        squares = squares + Square(
                            xOffset = (-150..250).random(),
                            colorIndex = (1..3).random()
                        )
                    }
                }
            ) {
                Text("Add Square")
            }
        }

        items(squares.size) { index ->
            FallingSquare(
                duration = 3500,
                colorIdx = squares[index].colorIndex,
                xOffset = squares[index].xOffset
            )
        }
    }
}