package com.example.buttonnaviigation.strukturdata

data class StdResponse (
    val message: String,
    val data: String
)

data class DataUser (
    val message: String,
    val data: Data
) {
    data class Data (
        val nama: String
    )
}