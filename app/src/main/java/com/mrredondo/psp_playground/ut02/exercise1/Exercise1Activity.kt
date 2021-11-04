package com.mrredondo.psp_playground.ut02.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mrredondo.psp_playground.R
import com.mrredondo.psp_playground.ut02.exercise1.data.MockApiClient
import com.mrredondo.psp_playground.ut02.exercise1.data.UserApiModel
import com.mrredondo.psp_playground.ut02.exercise1.data.UserRepository

class Exercise1Activity : AppCompatActivity() {

    private val TAG: String = Exercise1Activity::class.java.simpleName
    private val factory = ApiClientFactory<MockApiClient>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise1)
    }

    private fun setupView(){
        val action_mock = findViewById<Button>(R.id.action_mock)
        action_mock.setOnClickListener {

        }
    }

    private fun runRepository(idAction: Int){
        val apiClient = factory.build(idAction)
        val repository = UserRepository(apiClient)


    }
}