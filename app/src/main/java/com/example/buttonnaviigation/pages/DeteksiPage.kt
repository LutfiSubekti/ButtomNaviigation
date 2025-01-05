package com.example.buttonnaviigation.pages

import android.provider.OpenableColumns
import android.content.ContentResolver
import android.content.Context
import java.io.InputStream
import android.net.Uri
import android.os.Environment
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.FileProvider
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.buttonnaviigation.R
import com.example.buttonnaviigation.util.uploadFile
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun DeteksiPage (navController: NavHostController, modifier: Modifier = Modifier) {

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
            .padding(horizontal = 50.dp, vertical = 32.dp),
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
                        .size(50.dp)
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
                        val imageUri = getImageUri()
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
                        modifier = Modifier
                            .padding(5.dp)
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


                Spacer(modifier = Modifier.height(7.dp))

                Button(
                    onClick = {
                        if (selectedImages != null) {
                            GlobalScope.launch(Dispatchers.Main) {
                                try {
                                    val res = uploadFile(
                                        uriToFile(selectedImages!!, context)
                                    )
                                    val uri = Uri.encode(selectedImages.toString())
                                    navController.navigate("result/$uri/${res?.data}")
                                    Log.d("SuccessHTTPReq", "json: ${res?.data}")
                                } catch (e: Exception) {
                                    Log.e("ErrorHTTPReq", "Error fetching posts: ${e.message}")
                                }
                            }

                        }
                    },
                    colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50)), // Green color
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 50.dp), // Padding to prevent full width
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(text = "DETEKSI", color = Color.Black, fontSize = 16.sp)
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


fun uriToFile(uri: Uri, context: Context): File {
    val contentResolver: ContentResolver = context.contentResolver
    val fileName = getFileName(uri, contentResolver)

    // Buat file di cache directory
    val file = File(context.cacheDir, fileName)

    // Salin data dari URI ke file
    contentResolver.openInputStream(uri)?.use { inputStream: InputStream ->
        file.outputStream().use { outputStream ->
            inputStream.copyTo(outputStream)
        }
    }

    return file
}

private fun getFileName(uri: Uri, contentResolver: ContentResolver): String {
    var result: String? = null
    if (uri.scheme == "content") {
        val cursor = contentResolver.query(uri, null, null, null, null)
        cursor?.use {
            if (it.moveToFirst()) {
                val index = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                if (index != -1) {
                    result = it.getString(index)
                }
            }
        }
    }
    if (result == null) {
        result = uri.path
        val cut = result!!.lastIndexOf('/')
        if (cut != -1) {
            result = result!!.substring(cut + 1)
        }
    }
    return result ?: "temp_file"
}
