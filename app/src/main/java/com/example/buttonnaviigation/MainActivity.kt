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
import android.net.Uri
import androidx.navigation.NavType
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ButtonNaviigationTheme {
                //memanggil fungsi navigasi sebagai proses utama
                NavigationView()
            }
        }
    }
}



@Composable
//sebuah Fungsi dengan nama NavigationView
fun NavigationView() {
    // val merupakan variabel tidak dapat di ubah,
    val navController = rememberNavController()
    // navhost merupakan sebuah library untuk mendefinisikan route
    NavHost(navController = navController, startDestination = "welcome") {
        // variabel passing dan bisa di share kepada aktiviti lainya
        composable(
            "result/{uri}/{result}",
            arguments =  listOf(
                navArgument("uri") {
                    NavType.StringType
                },
                navArgument("result") {
                    NavType.StringType
                }
            )
        ) { backstack ->
            val uri = backstack.arguments?.getString("uri")?.let { Uri.decode(it) }
            val result = backstack.arguments?.getString("result")
            ResultScreen(navController, uri = Uri.parse(uri), result=result)
        }
        composable("welcome") { WelcomeScreen(navController) }
        composable("button") { ButtonBaar(navController) }
    }
}
