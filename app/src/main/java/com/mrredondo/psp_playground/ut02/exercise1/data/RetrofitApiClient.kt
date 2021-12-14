package com.mrredondo.psp_playground.ut02.exercise1.data

import com.mrredondo.psp_playground.ut02.UserApiModel

class RetrofitApiClient : ApiClient{

    override fun getUser(userId: Int): UserApiModel? {
        TODO("Not yet implemented")
    }

    override fun getUsers(): List<UserApiModel> {
        TODO("Not yet implemented")
    }
}