package com.curiozing.jetpackcomposeui.themes.theme2

import android.graphics.drawable.PaintDrawable
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.curiozing.jetpackcomposeui.R


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


        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        listOf(
                            Color(0xFF155761),
                            Color(0xFF114c57),
                            Color(0xFF0e3c4c)
                        )
                    )
                )


        ) {
            Box(modifier = Modifier.padding(horizontal = 50.dp, vertical = 50.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.grocery_lading_image),
                    contentDescription = ""
                )
            }
            Text(
                modifier = Modifier.padding(horizontal = 12.dp),
                text = "Discover the best products",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 32.sp,
                lineHeight = 40.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                modifier = Modifier.padding(horizontal = 18.dp),
                text = "FreshBox is an online groceries store that provides quality cooking ingredients at affordable prices.",
                fontSize = 16.sp,
                lineHeight = 20.sp,
                color = Color.White
            )

        }
    }
}
