package com.example.myapplication.repository

import com.example.myapplication.Interfaces.ApiService
import retrofit2.Retrofit.*;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://695b7w15-3000.brs.devtunnels.ms"

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }


}