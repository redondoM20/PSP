package com.mrredondo.psp_playground.ut02.exercise1

import com.mrredondo.psp_playground.R
import com.mrredondo.psp_playground.ut02.exercise1.data.ApiClient
import com.mrredondo.psp_playground.ut02.exercise1.data.MockApiClient
import com.mrredondo.psp_playground.ut02.exercise1.data.RetrofitApiClient


class ApiClientFactory <T : ApiClient>{
    fun build(idActionClicked: Int): ApiClient{
        return when (idActionClicked){
            R.id.action_mock -> MockApiClient()
            else -> RetrofitApiClient()
        }
    }
}