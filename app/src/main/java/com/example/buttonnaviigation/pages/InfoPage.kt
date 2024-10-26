package com.example.buttonnaviigation.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InfoPage (modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // Logo Placeholder Box (Replace with actual Image if available)
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color(0xFFA4A4A4), shape = RoundedCornerShape(60.dp)), // Placeholder color
            contentAlignment = Alignment.Center
        ) {
            // Add your Image here if available, using Image composable.
            Text(
                text = "LOGO",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // App Title
        Text(
            text = "KAWO",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6A4E42) // Coffee-like color
        )

        // Subtitle
        Text(
            text = "ARABICA COFFEE PLANT DISEASE DETECTION",
            fontSize = 14.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Description Box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFD1B999), shape = RoundedCornerShape(8.dp)) // Light brown background color
                .padding(16.dp)
        ) {
            Text(
                text = "KAWO - Arabica Coffee Plant Disease Detection is an Android application used to detect diseases in Arabica coffee plants through leaf images.",
                fontSize = 14.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}
