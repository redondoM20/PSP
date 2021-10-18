package com.mrredondo.psp_playground.ut02

import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {
    @GET("posts")
    fun getUsers(): Call<List<UserApiModel>>
    fun getPost(): Call<List<PostApiModel>>
}

