package com.mrredondo.psp_playground.ut02

interface ApiCallback<T>{
    fun onResponse(apiModel: T)
    fun onFailure(error: String)
}

class UserApiCallback: ApiCallback<UserApiModel>{
    override fun onResponse(apiModel: UserApiModel) {
        TODO("Not yet implemented")
    }

    override fun onFailure(error: String) {
        TODO("Not yet implemented")
    }
}