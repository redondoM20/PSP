package com.mrredondo.psp_playground.ut02

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiEndPoint {
    @GET("users")
    fun getUsers(): Call<List<UserApiModel>>

    @GET("users/{userId}")
    fun getUser(@Path("userId") userId: Int): Call<UserApiModel>

    @GET("posts")
    fun getPost(): Call<List<PostApiModel>>

    @PUT("posts/{userId}")
    fun putPosts()
}

