package com.curiozing.jetpackcomposeui

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
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
                shape = RoundedCornerShape(
                    topEndPercent = 20,
                    bottomEndPercent = 20,
                    bottomStartPercent = 20
                ),
                color = Color(0xFFffde01), modifier = Modifier
                    .height(height = screenHeight.minus(screenHeight.div(5)).dp)
                    .width(width = screenWidth.minus(screenWidth.div(2.25)).dp)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.93f)
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
                                containerColor = Color.White
                            ),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 2.dp // Apply elevation here
                            ),
                            shape = RoundedCornerShape(
                                topEndPercent = 20,
                                bottomEndPercent = 20,
                                bottomStartPercent = 20
                            ),
                        ) {
                            Column {
                                Text(
                                    modifier = Modifier.padding(16.dp),
                                    text = "FOODIES",
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.height(50.dp))
                                Column(modifier = Modifier.fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally) {
                                    Box(modifier = Modifier
                                        .size(70.dp)
                                        .clip(shape = CircleShape)
                                        .background(color = Color(0xFFffde01))) {
                                        Image(painter = painterResource(id = R.drawable.profile_female), contentDescription = "")
                                    }
                                    Text(
                                        modifier = Modifier.padding(16.dp),
                                        text = "Clara Mia",
                                        color = Color.Black,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold
                                    )

                                    Box(modifier = Modifier
                                        .clip(shape = RoundedCornerShape(50))
                                        .background(color = Color(0xFFffde01))) {
                                        Text(
                                            modifier = Modifier.padding(top = 4.dp, bottom = 4.dp, start = 12.dp, end = 12.dp),
                                            text = "My Orders",
                                            color = Color.Black,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(50.dp))
                                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                                        Column (horizontalAlignment = Alignment.CenterHorizontally){
                                           Image(
                                               modifier = Modifier.size(30.dp),
                                               imageVector = ImageVector.vectorResource(id =  R.drawable.wallet),
                                               contentDescription = "wallet"
                                           )
                                            Spacer(modifier = Modifier.height(4.dp))
                                            Text(
                                               modifier = Modifier.padding(top = 4.dp, bottom = 4.dp, start = 12.dp, end = 12.dp),
                                               text = "Wallet",
                                               color = Color.DarkGray,
                                               fontSize = 12.sp,
                                               fontWeight = FontWeight.Bold
                                           )
                                       }
                                       Column (horizontalAlignment = Alignment.CenterHorizontally){
                                           Image(
                                               modifier = Modifier.size(30.dp),
                                               imageVector = ImageVector.vectorResource(id =  R.drawable.home),
                                               contentDescription = "home"
                                           )
                                           Spacer(modifier = Modifier.height(4.dp))
                                           Text(
                                               modifier = Modifier.padding(top = 4.dp, bottom = 4.dp, start = 12.dp, end = 12.dp),
                                               text = "Home",
                                               color = Color.DarkGray,
                                               fontSize = 12.sp,
                                               fontWeight = FontWeight.Bold
                                           )
                                       }
                                    }
                                    Spacer(modifier = Modifier.height(40.dp))
                                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                                        Column (horizontalAlignment = Alignment.CenterHorizontally){
                                            Image(
                                                modifier = Modifier.size(30.dp),
                                                imageVector = ImageVector.vectorResource(id =  R.drawable.wishlist2),
                                                contentDescription = "wishlist"
                                            )
                                            Spacer(modifier = Modifier.height(4.dp))
                                            Text(
                                                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp, start = 12.dp, end = 12.dp),
                                                text = "Favourite",
                                                color = Color.DarkGray,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                        Column (horizontalAlignment = Alignment.CenterHorizontally){
                                            Image(
                                                modifier = Modifier.size(30.dp),
                                                imageVector = ImageVector.vectorResource(id =  R.drawable.config),
                                                contentDescription = "config"
                                            )
                                            Spacer(modifier = Modifier.height(4.dp))
                                            Text(
                                                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp, start = 12.dp, end = 12.dp),
                                                text = "Settings",
                                                color = Color.DarkGray,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }

                                    }
                                }
                            }
                        }

                    }

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .weight(0.07f)
                            .fillMaxSize()
                            .padding(bottom = 6.dp)
                    ) {
                        Text(
                            text = "Log out",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
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
    Box(
        modifier = Modifier
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