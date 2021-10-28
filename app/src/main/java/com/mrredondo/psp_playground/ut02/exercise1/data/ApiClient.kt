package com.mrredondo.psp_playground.ut02.exercise1.data

interface ApiClient {
    fun getUser(userId:Int) : UserApiModel?
    fun getUsers():List<UserApiModel>
}



