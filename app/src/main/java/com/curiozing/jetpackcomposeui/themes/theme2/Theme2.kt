package com.curiozing.jetpackcomposeui.themes.theme2


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
    modifier: Modifier = Modifier,
) {
    var rotationAngle by remember { mutableFloatStateOf(0f) }

    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f) // Ensures the Box is square
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
        val itemSize = maxWidth * 0.1f

        // Calculate the radius dynamically based on the available maxWidth
        val radius = maxWidth / 2f - itemSize / 2f

        items.forEachIndexed { index, _ ->
            val angle = 2 * Math.PI * index / items.size
            val offsetX = radius * cos(angle).toFloat()
            val offsetY = radius * sin(angle).toFloat()
            Box(
                modifier = Modifier
                    .offset(x = offsetX, y = offsetY)
                    .clip(CircleShape)
                    .background(color = Color.LightGray)
                    .rotate(-rotationAngle), // Counteracts the parent's rotation
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.padding(all = 12.dp),
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun Theme2() {
    Surface {
        Column {
            Column {
                RotatingWheel(
                    listOf(
                        "HI",
                        "Hello",
                        "Hey",
                        "Wow",
                        "HI",
                        "Hello",
                        "Hey",
                        "Wow",
                    ),
                    modifier = Modifier
                        .layout { measurable, constraints ->
                            val placeable = measurable.measure(constraints)
                            layout(placeable.width, placeable.height - 500) {
                                placeable.placeRelative(0, -500) // Shift up
                            }
                        }
                )
                Text(text = "Helloo")
            }
        }
    }
}



