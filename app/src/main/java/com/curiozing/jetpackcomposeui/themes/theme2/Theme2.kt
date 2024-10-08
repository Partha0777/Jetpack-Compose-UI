package com.curiozing.jetpackcomposeui.themes.theme2

import android.util.Log
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import kotlin.math.atan2
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun RotatingWheel(
    items: List<String>,
    modifier: Modifier,
) {
    var rotationAngle by remember { mutableStateOf(0f) }
    val screenHeight = LocalConfiguration.current.screenHeightDp
    Log.d("screenHeight ==", screenHeight.toString())
    val radius = screenHeight.div(3.2).dp
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(screenHeight.div(1.4).dp)
            .background(Color.Yellow)
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
            val offsetX = radius * cos(angle).toFloat()
            val offsetY = radius * sin(angle).toFloat()
            Box(
                modifier = Modifier
                    .offset(x = offsetX, y = offsetY)
                    .clip(CircleShape)
                    .background(color = Color.LightGray)
                    .rotate(-rotationAngle) // Counteract the parent's rotation
                    .size(50.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "")
            }
        }
    }
}

@Composable
fun Theme2() {
    val screenHeight = LocalConfiguration.current.screenHeightDp
    Surface {
        Column {
            Column {
                RotatingWheel(
                    listOf(
                        "HI",
                        "Hello",
                        "Hey",
                        "Wow",
                        "Hoeoo",
                        "HI",
                        "Hello",
                        "Hey",
                        "Wow",
                        "Hoeoo"
                    ),
                    modifier = Modifier
                        .layout { measurable, constraints ->
                            val placeable = measurable.measure(constraints)
                            Log.d("Height --> screenHeight", "${placeable.height} $screenHeight")
                            layout(placeable.width, placeable.height - (screenHeight + 100)) {
                                placeable.placeRelative(0, -(screenHeight + 100)) // Shift up
                            }
                        }
                )
                Text(text = "Hello")
            }
        }
    }
}





