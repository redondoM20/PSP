package com.mrredondo.psp_playground.ut03.ex01.app

import com.mrredondo.psp_playground.ut03.ex01.data.UserApiModel
import retrofit2.Response
import retrofit2.http.GET

interface Ut03Ex01ApiEndPoint {
    @GET("users")
    suspend fun getUsers(): Response<List<UserApiModel>>


}