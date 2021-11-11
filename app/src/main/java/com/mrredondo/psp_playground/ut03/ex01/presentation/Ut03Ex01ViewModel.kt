package com.mrredondo.psp_playground.ut03.ex01.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
}