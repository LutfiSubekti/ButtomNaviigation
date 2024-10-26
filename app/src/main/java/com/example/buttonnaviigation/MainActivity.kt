package com.example.buttonnaviigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.buttonnaviigation.ui.theme.ButtonNaviigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ButtonNaviigationTheme {
                NavigationView()
            }
        }
    }
}

@Composable
fun NavigationView() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "welcome") {
        // also pass navController to each screen so we can use navController in there
        composable("welcome") { WelcomeScreen(navController) }
        composable("button") { ButtonBaar(navController) }
    }
}
