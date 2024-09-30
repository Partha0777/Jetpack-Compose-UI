package com.curiozing.jetpackcomposeui.themes.theme2


import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import kotlin.math.roundToInt

@Composable
fun CircularListViewWithoutCanvas(
    items: List<String>,
    radius: Dp = 650.dp
) {
    var dragOffset by remember { mutableStateOf(0f) }
    val totalAngle = 360f
    val anglePerItem = totalAngle / items.size
    val radiusPx = radius.toPx()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectDragGestures(
                    onDrag = { _, dragAmount ->
                        dragOffset += dragAmount.y / 4.5f
                    }
                )
            }
    ) {
        items.forEachIndexed { index, item ->
            // Calculate the angle for each item, considering the drag offset
            val angle = ((index * anglePerItem + dragOffset) % totalAngle).toRadians()

            // Calculate the x, y position for each item
            val x = radiusPx * cos(angle) + 450
            val y = radiusPx * sin(angle) + 200

            // Offset each item based on its calculated position
            Box(
                modifier = Modifier
                    .size(60.dp) // Size of each item
                    .offset { IntOffset(x.roundToInt(), y.roundToInt()) },
                contentAlignment = Alignment.Center
            ) {
                BasicText(text = item) // You can replace this with any UI content
            }
        }
    }
}


// Helper function to convert degrees to radians
fun Float.toRadians(): Double = this * PI / 180f

// Extension function to convert Dp to pixels (px)
@Composable
fun Dp.toPx(): Float = with(LocalDensity.current) { this@toPx.toPx() }

// Helper extension function to convert degrees to radians

@Composable
fun CircularScrollScreenWithoutCanvas() {
    CircularListViewWithoutCanvas(
        items = List(8) { "Item $it" },
        radius = 160.dp
    )
}


@Composable
fun Theme2() {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularScrollScreenWithoutCanvas()

        }
    }
}





