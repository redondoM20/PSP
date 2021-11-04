package com.mrredondo.psp_playground.ut02.exercise2.app

import com.mrredondo.psp_playground.ut02.exercise2.data.remote.AlertApiModel

interface ApiClient {
    fun getAlerts(): List<AlertApiModel>
}