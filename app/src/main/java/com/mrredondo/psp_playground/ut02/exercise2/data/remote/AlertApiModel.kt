package com.mrredondo.psp_playground.ut02.exercise2.data.remote

import com.mrredondo.psp_playground.ut02.exercise2.domain.AlertModel

data class AlertApiModel(
    val alert_id: String,
    val title: String,
    val summary: String,
    val type: String,
    val date: String
){
    fun toDomainModel(): AlertModel = AlertModel(
        alert_id,
        title,
        type.toInt(),
        summary,
        date,
        "",
        "",
        emptyList()
    )
}