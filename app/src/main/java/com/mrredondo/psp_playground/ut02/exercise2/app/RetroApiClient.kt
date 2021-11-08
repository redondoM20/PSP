package com.mrredondo.psp_playground.ut02.exercise2.app

import com.mrredondo.psp_playground.ut02.exercise2.data.remote.AlertApiModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetroApiClient: ApiClient {
    private val urlEndPoint: String = "https://plagricola.sitehub.es/api/public/alerts/"
    private val apiEndPoint: ApiEndPoint

    init {
        apiEndPoint = buildApiService()
    }

    private fun buildApiService(): ApiEndPoint{
        return buildClient().create(ApiEndPoint::class.java)
    }

    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            //.client(buildHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /*private fun buildHttpClient() =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().also{
                it.level=HttpLogging
            } )
            .connectTimeout(30 , TimeUnit.SECONDS)
            .build()*/

    override fun getAlerts(): List<AlertApiModel> {
        val call = apiEndPoint.getAlerts()
        val response = call.execute()
        if (response.isSuccessful){
            val alerts = response.body()
            return alerts ?: mutableListOf()
        }else{
            return mutableListOf()
        }
    }
}