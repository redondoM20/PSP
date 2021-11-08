package com.mrredondo.psp_playground.ut02.exercise2.data.remote

import com.mrredondo.psp_playground.ut02.exercise2.app.ApiClient
import com.mrredondo.psp_playground.ut02.exercise2.domain.AlertModel

class AlertRemoteSource (private val apiClient: ApiClient){
    fun getAlerts(): List<AlertModel>{
        val alertApiModel = apiClient.getAlerts()
        return alertApiModel.map { apiModel -> apiModel.toDomainModel() }
    }
}