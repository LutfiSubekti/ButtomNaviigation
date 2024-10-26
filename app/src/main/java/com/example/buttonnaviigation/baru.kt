//package com.example.buttonnaviigation
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.yourappname.ui.theme.YourAppNameTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            YourAppNameTheme {
//                MainScreen()
//            }
//        }
//    }
//}
//
//@Composable
//fun MainScreen() {
//    Scaffold(
//        bottomBar = { BottomNavigationBar() }
//    ) {
//        DetectionScreenContent()
//    }
//}
//
//@Composable
//fun DetectionScreenContent() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        // Placeholder for the phone/camera icon
//        Image(
//            painter = painterResource(id = R.drawable.ic_camera_icon), // Replace with actual drawable
//            contentDescription = "Camera Icon",
//            modifier = Modifier
//                .size(100.dp)
//                .background(Color(0xFFEFEFEF), shape = RoundedCornerShape(12.dp))
//                .padding(16.dp)
//        )
//
//        Spacer(modifier = Modifier.height(32.dp))
//
//        // Button for accessing the camera
//        Button(
//            onClick = { /* Camera Access Functionality */ },
//            colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50)), // Green color
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 32.dp),
//            shape = RoundedCornerShape(20.dp)
//        ) {
//            Text(text = "AKSES KAMERA", color = Color.White, fontSize = 16.sp)
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Button for selecting from gallery
//        Button(
//            onClick = { /* Gallery Access Functionality */ },
//            colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50)), // Green color
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 32.dp),
//            shape = RoundedCornerShape(20.dp)
//        ) {
//            Text(text = "PILIH DARI GALERI", color = Color.White, fontSize = 16.sp)
//        }
//    }
//}
//
//@Composable
//fun BottomNavigationBar() {
//    NavigationBar(
//        containerColor = Color(0xFFE0D5C5) // Light beige color for background
//    ) {
//        NavigationBarItem(
//            icon = { Icon(painterResource(id = R.drawable.ic_home), contentDescription = "Home") },
//            label = { Text("Home") },
//            selected = true,
//            onClick = { /* Home Navigation */ }
//        )
//        NavigationBarItem(
//            icon = { Icon(painterResource(id = R.drawable.ic_detection), contentDescription = "Deteksi") },
//            label = { Text("Deteksi") },
//            selected = false,
//            onClick = { /* Detection Navigation */ }
//        )
//        NavigationBarItem(
//            icon = { Icon(painterResource(id = R.drawable.ic_about), contentDescription = "About") },
//            label = { Text("About") },
//            selected = false,
//            onClick = { /* About Navigation */ }
//        )
//    }
//}
