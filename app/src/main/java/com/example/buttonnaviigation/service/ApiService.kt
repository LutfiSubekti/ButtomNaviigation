package com.example.buttonnaviigation.service

import com.example.buttonnaviigation.strukturdata.DataUser
import com.example.buttonnaviigation.strukturdata.StdResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @Multipart
    @POST("/deteksi")
    suspend fun uploadFile(
        @Part file : MultipartBody.Part
    ) : Response<StdResponse>

    @GET("/deteksi/get-data")
    suspend fun getUser1(): DataUser
}