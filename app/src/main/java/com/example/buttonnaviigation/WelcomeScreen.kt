package com.example.buttonnaviigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


// digunakan untuk membangun UI dalam jetpack compose
@Composable
fun WelcomeScreen(
    //navController: NavHostController digunakan untuk mengatur navigasi antar layar
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    //sebagai wadah untuk beberapa elemen
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.avatar4),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        // Content
        Column(
            //menaruh posisi item
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {
            //memberikan spasi antar item
            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = null,
                modifier = Modifier
                    .width(320.dp)
                    .height(240.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                "SELAMAT DATANG",
                fontSize = 32.sp,
                fontFamily = onesFontFamily,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                "DETEKSI PENYAKIT.\nDAUN CABAI.",
                textAlign = TextAlign.Center,
                //fontFamily = onesFontFamily,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
            Button(
                onClick = { navController.navigate("button") },
                colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50)), // Green color
            ) {
                Text("Next",color = Color.Black, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }

}

val onesFontFamily = FontFamily(
    Font(R.font.dua,FontWeight.Normal),
)

//untuk meriview fungsi dari welcomescreen
@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(rememberNavController())
}