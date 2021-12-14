package com.mrredondo.psp_playground.ut02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mrredondo.psp_playground.R

class NetworkActivity : AppCompatActivity() {

    private val TAG = NetworkActivity::class.java.canonicalName

    private val apiClient: ApiClient = RetrofitApiClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //testSyncApiPost()
        //testSyncApi1()
    }

    private fun testSyncApi() {
        val users = apiClient.getUsers()
        if (users.isNotEmpty()) {
            users.forEach {
                Log.i(TAG, "$it")
            }
        } else {
            Log.i(TAG, "User list is empty")
        }
    }

    private fun testAsyncApi() {
        val threadNetwotk = Thread(Runnable {
            val users = apiClient.getUsers()
            if (users.isNotEmpty()) {
                users.forEach {
                    Log.i(TAG, "$it")
                }
            } else {
                Log.i(TAG, "User list is empty")
            }
        })
        threadNetwotk.start()
    }

    private fun testSyncApi1(){
        val posts = apiClient.getPost()
        if (posts.isNotEmpty()){
            posts.forEach{
                Log.i(TAG, "$it")
            }
        } else {
            Log.i(TAG, "User list is empty")
        }
    }

    private fun testAsyncApi1() {
        val threadNetwotk = Thread(Runnable {
            val posts = apiClient.getPost()
            if (posts.isNotEmpty()) {
                posts.forEach {
                    Log.i(TAG, "$it")
                }
            } else {
                Log.i(TAG, "User list is empty")
            }
        })
        threadNetwotk.start()
    }

    private fun exampleCallback() {
        val exampleCallback = ExampleCallback()
        val users = exampleCallback.getUsers()
        exampleCallback.getUsers(object : ApiCallback<List<UserApiModel>> {
            override fun onResponse(apiModel: List<UserApiModel>) {
                users.forEach {
                    Log.i(TAG, "$it")
                }
            }

            override fun onFailure(error: String) {
                Log.i(TAG, error)
            }
        })
        Log.i(TAG, "I'm not waiting")
    }

    /*private fun exampleCallback1(){
        val exampleCallback = ExampleCallback()
        val posts = exampleCallback.getPosts()
        exampleCallback.getPosts(object : ApiCallback<List<PostApiModel>>

        )
    }*/

    private fun testCallbackApi() {
        apiClient.getUsers(object : ApiCallback<List<UserApiModel>> {
            override fun onResponse(apiModel: List<UserApiModel>) {
                apiModel.forEach {
                    Log.i(TAG, "$it")
                }
            }

            override fun onFailure(error: String) {
                Log.e(TAG, error)
            }
        })
    }

    private fun testSyncApiPost() {
        val posts = apiClient.getPost()
        if (posts.isNotEmpty()) {
            posts.forEach {
                Log.i(TAG, "$it")
            }
        } else {
            Log.i(TAG, "User list is empty")
        }
    }
}