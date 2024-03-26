package com.example.fooddeliveryapp.data.api


import retrofit2.http.GET

interface ApiService {

    @GET("categories")
    suspend fun getCategories(): Result
}