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
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.*
import kotlin.math.*

@Composable
fun RotatingWheel(
    items: List<String>,
    wheelSize: Dp = 400.dp
) {
    var rotationAngle by remember { mutableStateOf(0f) }
    val radius = wheelSize / 2

    Box(
        modifier = Modifier
            .size(wheelSize)
            .layout { measurable, constraints ->
                // Measure the child view
                val placeable = measurable.measure(constraints)
                val width = placeable.width
                val height = placeable.height

                // Define the layout with half the height
                layout(width, height) {
                    // Offset the view upwards by half its height
                    placeable.placeRelative(0, -height/2)
                }
            }
            .pointerInput(Unit) {
                var previousAngle = 0.0
                detectDragGestures(
                    onDragStart = { offset ->
                        val center = Offset(size.width / 2f, size.height / 2f)
                        previousAngle = atan2(
                            y = (offset.y - center.y),
                            x = (offset.x - center.x)
                        ).toDouble()
                    },
                    onDrag = { change, _ ->
                        val center = Offset(size.width / 2f, size.height / 2f)
                        val currentAngle = atan2(
                            y = (change.position.y - center.y),
                            x = (change.position.x - center.x)
                        ).toDouble()
                        val angleDelta = Math
                            .toDegrees(currentAngle - previousAngle)
                            .toFloat()
                        rotationAngle += angleDelta
                        previousAngle = currentAngle
                        change.consume()
                    }
                )
            }
            .rotate(rotationAngle),
        contentAlignment = Alignment.Center
    ) {
        items.forEachIndexed { index, _ ->
            val angle = 2 * Math.PI * index / items.size
            val offsetX = (radius.value * cos(angle)).dp
            val offsetY = (radius.value * sin(angle)).dp

            Box(
                modifier = Modifier
                    .offset(x = offsetX, y = offsetY)
                    .rotate(-rotationAngle) // Counteract the parent's rotation
                    .size(50.dp),
                contentAlignment = Alignment.Center
            ) {
                // Your item content remains upright
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "")
            }
        }
    }
}


@Composable
fun Theme2() {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            RotatingWheel(listOf("HI", "Hello", "Hey", "wow", "Hoeoo", "HI", "Hello", "Hey", "wow", "Hoeoo"))

        }
    }
}



