package com.example.myapplication.Interfaces

import com.example.myapplication.model.Usuario
import retrofit2.Response
import retrofit2.http.*;

interface ApiService {

    @GET("/users")
    suspend fun getUsers(): Response<List<Usuario>>;

    @GET("/users/{username}")
    suspend fun getUser(@Path("username") username: String): Response<Usuario>;

    @POST("/users")
    suspend fun createUser(@Body user: Usuario): Response<Usuario>

    @DELETE
    suspend fun deleteUser(@Query("username") username: String): Response<Usuario>

    @PUT
    suspend fun updateUser(@Query("username") username: String, @Body user: Usuario): Response<Usuario>
}

