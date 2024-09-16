package com.curiozing.jetpackcomposeui.themes.themes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.curiozing.jetpackcomposeui.model.themes.Themes
import com.curiozing.jetpackcomposeui.themes.theme1.Theme1
import com.curiozing.jetpackcomposeui.ui.theme.JetpackComposeUITheme

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
    val themeList = mutableListOf(Themes(1,"Theme 1", "Theme1"))
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        Text(text = "Themes", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(content = {
            themeList.forEach {
                item {
                    Text(text = it.themeName, modifier = Modifier.clickable {
                        navigateToTheme.invoke(it.route)
                    })
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