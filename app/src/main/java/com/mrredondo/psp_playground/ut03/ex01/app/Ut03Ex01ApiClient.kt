package com.mrredondo.psp_playground.ut03.ex01.app

import com.mrredondo.psp_playground.ut03.ex01.data.UserApiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiClient {
    suspend fun getUsers(): List<UserApiModel>
}

class RetrofitApiClient : ApiClient {
    private val urlEndPoint: String = "https://jsonplaceholder.typicode.com/"
    private var apiEndPoint: Ut03Ex01ApiEndPoint

    init {
        apiEndPoint = buildApiService()
    }

    private fun buildApiService(): Ut03Ex01ApiEndPoint {
        return buildClient().create(Ut03Ex01ApiEndPoint::class.java)
    }

    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    override suspend fun getUsers(): List<UserApiModel> = withContext(Dispatchers.IO){
        val response = apiEndPoint.getUsers()
        if (response.isSuccessful){
            val users = response.body()
            users ?: mutableListOf()
        }else{
            mutableListOf()
        }
    }
}