package com.mrredondo.psp_playground.ut03.ex01.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrredondo.psp_playground.ut03.ex01.app.RetrofitApiClient
import com.mrredondo.psp_playground.ut03.ex01.data.UserApiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Ut03Ex01ViewModel() : ViewModel() {
    fun getUsersGlobalScope(){
        viewModelScope.launch(Dispatchers.Main){
            var i = 0
            while (true){
                Log.d("@dev", "Hola: $i")
                delay(1000)
                i += 1
            }
        }
        Log.d("@dev", "Ui Thread")
    }

    fun getUserViewModelScope(){
        val apiClient = RetrofitApiClient()

        viewModelScope.launch(Dispatchers.Main) {
            Log.d("@dev", "Llamo a API from ViewModelScope.....")
            val users = apiClient.getUsers()
            Log.d("@dev", "ViewModelScope: $users")
        }

        GlobalScope.launch(Dispatchers.Main){
            Log.d("@dev", "Llamo a API.....")
            val users: List<UserApiModel>
            users = apiClient.getUsers()
            Log.d("@dev", "GlobalScope: $users")
        }
    }
}