package com.curiozing.jetpackcomposeui.themes.theme2

import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
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
        LandingScreen()
    }
}

@Composable
fun LandingScreen() {
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { 2 }
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
        Row(
            modifier = Modifier.padding(top = 60.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp),
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "",
                tint = Color.White
            )
            Text(
                text = "FreshBox",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 28.sp,
                lineHeight = 40.sp,
                color = Color.White
            )
        }
        HorizontalPager(state = pagerState) {
            if (it == 0) {
                LandingPageViewItem(
                    title = "Discover the best products",
                    desc = "FreshBox is an online groceries store that provides quality cooking ingredients at affordable prices.",
                    imageId = R.drawable.grocery_lading_image
                )
            } else if (it == 1) {
                LandingPageViewItem(
                    title = "Best Offers",
                    desc = "Stock up and save! Get incredible savings when you buy in bulk. Whether it's grains, oils, or snacks, the more you buy, the more you save. Perfect for families and home cooks alike.",
                    imageId = R.drawable.grocery_lading_image
                )
            }
        }
    }
}


@Composable
fun LandingPageViewItem(title: String, desc: String, imageId: Int) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(modifier = Modifier.padding(horizontal = 50.dp, vertical = 20.dp)) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = ""
            )
        }
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 12.dp),
                text = title,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 28.sp,
                lineHeight = 40.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                modifier = Modifier.padding(horizontal = 18.dp),
                text = desc,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                color = Color(0xFFD7D7D7)
            )
        }
    }

}
