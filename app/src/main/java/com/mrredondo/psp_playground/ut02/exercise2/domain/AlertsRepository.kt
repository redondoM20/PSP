package com.mrredondo.psp_playground.ut02.exercise2.domain

interface AlertsRepository {
    fun fetchAll(): List<AlertModel>
}