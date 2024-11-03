package com.example.buttonnaviigation
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun ResultScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier)  {

    // Background Image
    Image(
        painter = painterResource(id = R.drawable.avatar4),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp, vertical = 32.dp),
        contentAlignment = Alignment.Center

    ) {
        // Rounded Rectangle with Shadow
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(580.dp)
                .background(
                    color = Color.White.copy(alpha = 0.9f),
                    shape = RoundedCornerShape(50.dp)
                )
        )

        // Success Message
        Text(
            text = "Detection Successfully .",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF325A3E),
            modifier = Modifier
                .padding(top = 359.dp)
                .align(Alignment.TopCenter)
        )

        // Additional Message
        Text(
            text = "Your payment was successfully!\n\nJust wait Plantfresher arrive at home asap.",
            fontSize = 16.sp,
            color = Color(0xFFA1A1A1),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 432.dp)
                .align(Alignment.TopCenter)
        )

        // Ellipse Shape with Icon
        Box(
            modifier = Modifier
                .padding(top = 150.dp)
                .size(150.dp)
                .background(
                    color = Color.White,
                    shape = CircleShape
                )
                .border(6.dp, Color(0xFFA4A4A4), CircleShape)
                .align(Alignment.TopCenter),
            contentAlignment = Alignment.Center
        ) {

        }
    }
}


//untuk meriview fungsi dari welcomescreen
@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun ResultScreenPreview() {
    ResultScreen(rememberNavController())
}
