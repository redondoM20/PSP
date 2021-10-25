package com.mrredondo.psp_playground.ut02.exercise1.data

import com.mrredondo.psp_playground.ut02.UserApiModel

interface ApiClient{
    fun getUser(userId: Int) : UserApiModel?
    fun getUsers() : List<UserApiModel>
}