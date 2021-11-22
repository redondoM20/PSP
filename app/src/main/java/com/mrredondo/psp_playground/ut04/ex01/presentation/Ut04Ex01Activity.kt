package com.mrredondo.psp_playground.ut04.ex01.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mrredondo.psp_playground.databinding.ActivityUt04Ex01Binding

class Ut04Ex01Activity : AppCompatActivity() {

    private val binding: ActivityUt04Ex01Binding by lazy {
        ActivityUt04Ex01Binding.inflate(layoutInflater)
    }

    private val viewModel: Ut04Ex01ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView()
        setupViewStateObservers()
    }

    private fun setupView() {
        binding.actionLivedata.setOnClickListener{
            viewModel.loadData()
        }
    }

    private fun setupViewStateObservers(){
        val nameObserver = Observer<AlertViewState> { alertViewState ->
            Toast.makeText(this, alertViewState.name, Toast.LENGTH_SHORT).show()
        }

        viewModel.alertViewState.observe(this, nameObserver)
    }
}