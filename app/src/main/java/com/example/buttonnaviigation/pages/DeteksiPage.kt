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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buttonnaviigation.R


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import android.os.Environment
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.FileProvider
import java.io.File
import java.text.SimpleDateFormat
import java.util.*


@Composable
fun DeteksiPage (modifier: Modifier = Modifier) {

    val onesFontFamily = FontFamily(
        Font(R.font.dua,FontWeight.Normal),
    )
    // Background Image
    Image(
        painter = painterResource(id = R.drawable.avatar4),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
    // Outer box frame
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp, vertical = 32.dp),
        contentAlignment = Alignment.Center

    ) {
        var selectedImages by remember {
            mutableStateOf<Uri?>(null)
        }
        val context = LocalContext.current
        // Fungsi untuk membuat file temporary baru
        fun createImageFile(): File {
            return File.createTempFile(
                "JPEG_${SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())}_",
                ".jpg",
                context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            ).apply {
                createNewFile()
            }
        }

        // Menyimpan file dalam state
        var tempImageFile by remember { mutableStateOf(createImageFile()) }

        // Fungsi untuk mendapatkan Url baru
        fun getImageUri(): Uri {
            return FileProvider.getUriForFile(
                context,
                "${context.packageName}.provider",
                tempImageFile
            )
        }

        var imageUri = remember {
            FileProvider.getUriForFile(
                context,
                "${context.packageName}.provider",
                tempImageFile
            )
        }

        // Launcher untuk membuka kamera
        val cameraLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.TakePicture()
        ) { success ->
            if (success) {
                selectedImages = getImageUri()
            }
        }

        // Inner box for frame with rounded corners and background color
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(580.dp)
                .background(
                    color = Color.White.copy(alpha = 0.9f),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // tempat for camera icon
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .background(Color(0xFFDDDDDD), shape = RoundedCornerShape(20.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    if (selectedImages == null) {
                        Image(
                            painter = painterResource(id = R.drawable.picture),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .width(50.dp)
                                .height(50.dp)
                        )
                    }
                    ImageLayoutView(selectedImages)
                }

                Spacer(modifier = Modifier.height(100.dp))

                Text(
                    text = "CabaiCare",
                    fontFamily = onesFontFamily,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF6A4E42) // Coffee-like color
                )
                Text(
                    text = "CABAI PLANT DISEASE DETECTION",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(10.dp))
                // Camera access button
                Button(
                    onClick = {
                        tempImageFile = createImageFile()
                        imageUri = getImageUri()
                        cameraLauncher.launch(imageUri)
                    },
                    colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50)), // Green color
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 50.dp), // Padding to prevent full width
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.camera),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.padding(5.dp)
                        .width(30.dp)
                        .height(30.dp)
                    )
                    Text(text = "AKSES KAMERA", color = Color.Black, fontSize = 16.sp)
                }

                Spacer(modifier = Modifier.height(5.dp))

                val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.PickVisualMedia(),
                    onResult = { uri -> selectedImages = uri }
                )

                // Gallery access button
                Button(
                    onClick = {
                        singlePhotoPickerLauncher.launch(
                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                        )
                    },
                    colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50)), // Green color
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 50.dp), // Padding to prevent full width
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.photo1),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .padding(5.dp)
                            .width(30.dp)
                            .height(30.dp)

                    )
                    Text(text = "PILIH DARI GALERI", color = Color.Black, fontSize = 16.sp)
                }

            }
        }
    }
}

@Composable
fun ImageLayoutView(selectedImages: Uri?) {
    AsyncImage(
        model = selectedImages,
        contentDescription = null,
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.Fit
    )

}
