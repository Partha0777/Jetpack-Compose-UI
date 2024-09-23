package com.curiozing.jetpackcomposeui.themes.themes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.curiozing.jetpackcomposeui.themes.theme1.Theme1
import com.curiozing.jetpackcomposeui.ui.theme.JetpackComposeUITheme
import com.curiozing.jetpackcomposeui.utils.MockData.themeList

class ThemesView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeUITheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavHost()
                }
            }
        }
    }
}

@Composable
fun ThemeList(navigateToTheme: (page: String) -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        Row {
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Themes List", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(12.dp))
        LazyColumn(content = {
            themeList.forEach {
                item {
                    Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp, vertical = 4.dp), colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ), shape = RoundedCornerShape(24.dp), elevation = CardDefaults.elevatedCardElevation(defaultElevation = 1.5.dp)) {
                        Text(text = it.themeName, modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp).clickable {
                            navigateToTheme.invoke(it.route)
                        })
                    }

                }
            }
        })
    }
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "themes") {
        composable("themes") {
            ThemeList {
                navController.navigate(it)
            }
        }
        composable("Theme1") {
            Theme1()
        }
    }
}