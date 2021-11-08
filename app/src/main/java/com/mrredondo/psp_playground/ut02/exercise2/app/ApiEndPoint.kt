package com.mrredondo.psp_playground.ut02.exercise2.app

import com.mrredondo.psp_playground.ut02.exercise2.data.remote.AlertApiModel
import retrofit2.Call
import retrofit2.http.GET


interface ApiEndPoint {
    @GET("alerts")
    fun getAlerts(): Call<List<AlertApiModel>>
}