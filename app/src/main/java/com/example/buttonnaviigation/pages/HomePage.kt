package com.example.buttonnaviigation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buttonnaviigation.R


@Composable
fun HomePage (modifier: Modifier = Modifier) {
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
            painter = painterResource(id = R.drawable.list2), // Replace with your icon
            contentDescription = "Instruction Icon",
            modifier = Modifier
            .width(320.dp)
            .height(240.dp),
        contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "CARA MENGGUNAKAN APLIKASI",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .background(Color.Black.copy(alpha = 0.1f), shape = RoundedCornerShape(10.dp))
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        InstructionStep(stepNumber = "1", instruction = "Klik Tombol Home/Tombol Tengah")
        Spacer(modifier = Modifier.height(16.dp))
        InstructionStep(stepNumber = "2", instruction = "Kemudian Pilih Akses Kamera Ataupun Galeri Perangkat Anda")
    }
}

@Composable
fun InstructionStep(stepNumber: String, instruction: String) {
    Row(
        modifier = Modifier
            .background(Color(0xFF139B5C), shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Text(
            text = stepNumber,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier

        )
        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = instruction,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}

