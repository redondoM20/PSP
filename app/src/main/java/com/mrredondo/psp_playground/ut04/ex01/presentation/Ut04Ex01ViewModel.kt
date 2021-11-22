package com.mrredondo.psp_playground.ut04.ex01.presentation

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class Ut04Ex01ViewModel : ViewModel(){
    val alertViewState: LiveData<AlertViewState>
    get() = _alertViewState



    private val _alertViewState: MutableLiveData<AlertViewState> by lazy {
        MutableLiveData<AlertViewState>()
    }

    fun loadData() = viewModelScope.launch(Dispatchers.Main) {
        delay(1000L)
        _alertViewState.postValue(AlertViewState(Random.toString(), Random.toString()))
    }
}