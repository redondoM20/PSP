package com.mrredondo.psp_playground.ut02.exercise2.data

import com.mrredondo.psp_playground.ut02.exercise2.data.remote.AlertRemoteSource
import com.mrredondo.psp_playground.ut02.exercise2.domain.AlertModel
import com.mrredondo.psp_playground.ut02.exercise2.domain.AlertsRepository

class AlertsDataRepository (private val alertRemote: AlertRemoteSource): AlertsRepository{
    override fun fetchAll(): List<AlertModel> {
        val remoteModel = alertRemote.getAlerts()
        return remoteModel
    }
}
