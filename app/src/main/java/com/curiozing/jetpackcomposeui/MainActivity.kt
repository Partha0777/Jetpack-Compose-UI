package com.curiozing.jetpackcomposeui

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet

import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.curiozing.jetpackcomposeui.ui.theme.JetpackComposeUITheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeUITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Home()
                }
            }
        }
    }
}

@Composable
fun Home() {
    SideNavigationMenu()

}

@Composable
fun SideNavigationMenu() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val localConfiguration = LocalConfiguration
    val screenWidth = localConfiguration.current.screenWidthDp
    val screenHeight = localConfiguration.current.screenHeightDp
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Surface(
                shape = RoundedCornerShape(topEndPercent = 20, bottomEndPercent = 20, bottomStartPercent = 20),
                color = Color(0xFFffde01), modifier = Modifier
                    .height(height = screenHeight.minus(screenHeight.div(4)).dp)
                    .width(width = screenWidth.minus(screenWidth.div(2.25)).dp)
            ) {

                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFffde01))) {
                    Column(modifier = Modifier
                        .weight(0.91f)
                        .fillMaxSize()
                    ) {
                        Card(
                            modifier = Modifier
                                .clip(
                                    shape = RoundedCornerShape(
                                        bottomStartPercent = 20,
                                        bottomEndPercent = 20
                                    )
                                )
                                .fillMaxSize()
                                .padding(bottom = 6.dp),
                            colors = CardDefaults.cardColors(
                                contentColor = Color.White
                            ),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 2.dp // Apply elevation here
                            ),
                            shape = RoundedCornerShape(topEndPercent = 20, bottomEndPercent = 20, bottomStartPercent = 20),
                            ) {
                            Column(modifier = Modifier.fillMaxSize().background(Color.White)) {

                            }
                        }

                    }

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .weight(0.09f)
                            .fillMaxSize().padding(bottom = 6.dp)) {
                        Text(text = "Log out", color =  Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                }

            }

        }, content = {
            Column {
                IconButton(
                    onClick = {
                        scope.launch {
                            drawerState.open()
                        }
                    }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "")
                }
            }
        })
}

@Composable
fun BottomShadow(alpha: Float = 0.1f, height: Dp = 28.dp) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(height)
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color.Black.copy(alpha = alpha),
                    Color.Transparent,
                )
            )
        )
    )
}
@Preview
@Composable
fun GreetingPreview() {
    JetpackComposeUITheme {
        Home()
    }
}