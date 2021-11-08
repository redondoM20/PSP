package com.mrredondo.psp_playground.ut02.exercise2.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mrredondo.psp_playground.R
import com.mrredondo.psp_playground.ut02.exercise2.app.ApiClient
import com.mrredondo.psp_playground.ut02.exercise2.app.MockApiClient
import com.mrredondo.psp_playground.ut02.exercise2.app.RetroApiClient
import com.mrredondo.psp_playground.ut02.exercise2.data.AlertsDataRepository
import com.mrredondo.psp_playground.ut02.exercise2.data.remote.AlertRemoteSource
import com.mrredondo.psp_playground.ut02.exercise2.domain.AlertsRepository
import kotlin.concurrent.thread

class AlertsActivity : AppCompatActivity() {

    private val TAG = AlertsActivity::class.java.simpleName
    private val repository: AlertsRepository =
        AlertsDataRepository(AlertRemoteSource(MockApiClient()))
    private val apiClient: ApiClient = RetroApiClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alerts)
        //render()
        testAsyncApi()
    }

    private fun render(){
        val model = repository.fetchAll()
        Log.d(TAG, model.toString())
    }

    private fun testAsyncApi(){
        val threadNetwork = Thread(Runnable {
            val alerts = apiClient.getAlerts()
            if (alerts.isNotEmpty()){
                Log.i(TAG, "$alerts")
            }else{
                Log.i(TAG, "Lista de alertas vacia")
            }
        })
        threadNetwork.start()
    }
}