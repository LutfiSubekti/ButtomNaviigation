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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DeteksiPage (modifier: Modifier = Modifier) {
    // Outer box frame
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp, vertical = 32.dp),
        contentAlignment = Alignment.Center

    ) {
        // Inner box for frame with rounded corners and background color
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFD1B999), shape = RoundedCornerShape(8.dp))
                .padding(24.dp), // Padding within the frame
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Placeholder for camera icon
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .background(Color(0xFFDDDDDD), shape = RoundedCornerShape(20.dp)),
                    contentAlignment = Alignment.Center
                ) {
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Camera access button
                Button(
                    onClick = { /* Camera Access Functionality */ },
                    colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50)), // Green color
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp), // Padding to prevent full width
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(text = "AKSES KAMERA", color = Color.White, fontSize = 16.sp)
                }

                Spacer(modifier = Modifier.height(5.dp))

                // Gallery access button
                Button(
                    onClick = { /* Gallery Access Functionality */ },
                    colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50)), // Green color
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp), // Padding to prevent full width
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(text = "PILIH DARI GALERI", color = Color.White, fontSize = 16.sp)
                }
            }
        }
    }
}

