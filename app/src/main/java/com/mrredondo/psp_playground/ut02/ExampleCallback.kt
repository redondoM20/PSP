package com.mrredondo.psp_playground.ut02

import android.util.Log

class ExampleCallback {
    private val TAG = NetworkActivity::class.java.canonicalName

    fun getUsers(): List<UserApiModel> {
        Thread(Runnable {
            Thread.sleep(5000)

            val user = UserApiModel(1, "Usuario 1", "Usuario1", "user@email.es")

            Log.i(TAG, "$user")
        }).start()
        return mutableListOf()
    }


    fun getUsers(apiCallback: ApiCallback<List<UserApiModel>>) {
        Thread(Runnable {

            Thread.sleep(5000)

            val user = UserApiModel(1, "Usuario 1", "Usuario1", "user@email.es")

            apiCallback.onResponse(mutableListOf(user))

        }).start()
    }

    /*fun getPosts(): List<PostApiModel>{
        Thread(Runnable {
            Thread.sleep(5000)
            val  post = PostApiModel(1, 1, "User1", "User1")
            Log.i(TAG, "$post")
        }).start()
        return mutableListOf()
    }

    fun getPosts(apiCallback: ApiCallback<List<PostApiModel>>) {
        Thread(Runnable {
            Thread.sleep(5000)
            val post = PostApiModel(1, 1, "User1", "User1")
            apiCallback.onResponse(mutableListOf(post))
        })
    }*/
}