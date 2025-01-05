package com.example.buttonnaviigation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buttonnaviigation.R


val onesFontFamily = FontFamily(
    Font(R.font.dua,FontWeight.Normal),
)

@Composable
fun InfoPage (modifier: Modifier = Modifier) {
    // Background Image
    Image(
        painter = painterResource(id = R.drawable.avatar4),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = null,
            modifier = Modifier
                .width(320.dp)
                .height(240.dp),
            contentScale = ContentScale.Fit
        )
        // App Title
        Text(
            text = "CabaiCare",
            fontFamily = onesFontFamily,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6A4E42) // Coffee-like color
        )
        // Subtitle
        Text(
            text = "CABAI PLANT DISEASE DETECTION",
            fontSize = 14.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Description Box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF139B5C), shape = RoundedCornerShape(8.dp)) // Light brown background color
                .padding(16.dp)
        ) {
            Text(
                text = "CabaiCare - Aplikasi pendeteksi penyakit pada tanaman cabai merupakan solusi berbasis teknologi  untuk menganalisis gejala penyakit pada daun cabai secara cepat dan akurat, Untuk meempermudah  mengambil tindakan pencegahan atau penanganan dengan tepat untuk meningkatkan hasil panen.",
                fontSize = 14.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}
