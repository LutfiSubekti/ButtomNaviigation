package com.example.buttonnaviigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.buttonnaviigation.pages.DeteksiPage
import com.example.buttonnaviigation.pages.HomePage
import com.example.buttonnaviigation.pages.InfoPage

@Composable
fun Mainscren(
    navController: NavHostController,
    modifier: Modifier = Modifier
)  {
    val navItemList = listOf(
        Navitem(label = "Home", Icons.Default.Home),
        Navitem(label = "Search", Icons.Default.Person),
        Navitem(label = "Info", Icons.Default.Info)

    )
    var selectedIndex by remember{ mutableStateOf(0) }

    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, navitem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            Icon(imageVector = navitem.icon, contentDescription = "icon")
                        },
                        label = {
                            Text(text = navitem.label)
                        }
                    )
                }
            }

        }
        ) { innerPadding ->
        Contenscren(modifier = Modifier.padding(innerPadding),selectedIndex)

    }

}

@Composable
fun Contenscren(modifier: Modifier = Modifier, selectedIndex : Int) {
    when(selectedIndex){
        0-> HomePage()
        1-> DeteksiPage()
        2-> InfoPage()
    }

}