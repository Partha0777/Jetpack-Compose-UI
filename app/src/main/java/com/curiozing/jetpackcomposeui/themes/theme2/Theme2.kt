package com.curiozing.jetpackcomposeui.themes.theme2

import androidx.compose.foundation.background
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat


@Composable
fun Theme2() {
    Surface {
        Column(modifier = Modifier.fillMaxSize().background(brush = Brush.linearGradient(
            listOf(
                Color(0xFF155761),
                Color(0xFF114c57),
                Color(0xFF0e3c4c)
            )
        ))) {
            Box {
            }
        }
    }
}
