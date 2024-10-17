package com.curiozing.jetpackcomposeui.themes.theme2

import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat


@Composable
fun Theme2() {
    Surface {
        val context = LocalContext.current
        val window = (context as? ComponentActivity)?.window
        WindowCompat.setDecorFitsSystemWindows(window!!, false)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

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
