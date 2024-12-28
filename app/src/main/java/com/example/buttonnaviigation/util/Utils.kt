package com.example.buttonnaviigation.util

import com.example.buttonnaviigation.service.ObjApiService
import com.example.buttonnaviigation.strukturdata.StdResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

suspend fun uploadFile(file : File) : StdResponse? {
    return ObjApiService.api.uploadFile(
        MultipartBody.Part
            .createFormData(
                "image",
                file.name,
                file.asRequestBody()
            )
    ).body()
}
