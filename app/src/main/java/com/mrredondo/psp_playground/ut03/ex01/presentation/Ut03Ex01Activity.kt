package com.mrredondo.psp_playground.ut03.ex01.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mrredondo.psp_playground.R
import androidx.activity.viewModels

class Ut03Ex01Activity : AppCompatActivity() {

    private val TAG = Ut03Ex01Activity::class.java.simpleName

    private val viewModel by viewModels<Ut03Ex01ViewModel>()
    private lateinit var thread1: Thread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut03_ex01)
        //exampleThread()
        exampleCoroutines()
    }

    private fun exampleThread(){
        thread1 = Thread {
            var i = 0
            while (true){
                Log.d(TAG, "Hola: $i")
                Thread.sleep(1000)
                i += 1
            }
        }
        thread1.start()
    }

    private fun exampleCoroutines(){
        viewModel.getUsersGlobalScope()
    }

    override fun onDestroy(){
        super.onDestroy()

        if (this::thread1.isInitialized){
            thread1.interrupt()
        }
    }
}