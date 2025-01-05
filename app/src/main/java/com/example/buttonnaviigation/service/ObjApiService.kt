package com.example.buttonnaviigation.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ObjApiService {
    private const val BASE_URL = "http://103.193.176.162:8000"

    val api: ApiService by lazy {
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}