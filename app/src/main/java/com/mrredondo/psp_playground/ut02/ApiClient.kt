package com.mrredondo.psp_playground.ut02

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiClient {
    fun getUsers(): List<UserApiModel>
    fun getUsers(callback: ApiCallback<List<UserApiModel>>)
    fun getUser(userId: Int) : UserApiModel?
    fun getPost(): List<PostApiModel>
    //fun getPost(callback: ApiCallback<List<PostApiModel>>)
}

class MockApiClient : ApiClient {
    override fun getUsers(): List<UserApiModel> {
        return mutableListOf(
            UserApiModel(1, "Usuario 1", "Usuario1", "user@email.es"),
            UserApiModel(2, "Usuario 2", "Usuario2", "user@email.es"),
            UserApiModel(3, "Usuario 3", "Usuario3", "user@email.es"),
            UserApiModel(4, "Usuario 4", "Usuario4", "user@email.es"),
        )
    }

    override fun getUsers(callback: ApiCallback<List<UserApiModel>>) {
        callback.onResponse(
            mutableListOf(
                UserApiModel(1, "Usuario 1", "Usuario1", "user@email.es"),
                UserApiModel(2, "Usuario 2", "Usuario2", "user@email.es"),
                UserApiModel(3, "Usuario 3", "Usuario3", "user@email.es"),
                UserApiModel(4, "Usuario 4", "Usuario4", "user@email.es"),
            )
        )
    }

    override fun getUser(userId: Int): UserApiModel{
        return UserApiModel(1, "Usuario 1", "Usuario1", "user@email.es")
    }

    override fun getPost(): List<PostApiModel> {
        return mutableListOf(
            PostApiModel(1, 1, "User1", "User1"),
            PostApiModel(2, 2, "User2", "User2"),
            PostApiModel(3, 3, "User3", "User3"),
            PostApiModel(4, 4, "User4", "User4"),
        )
    }


    /*override fun getPost(callback: ApiCallback<List<PostApiModel>>) {
        callback.onResponse(
            mutableListOf(
                PostApiModel(1, 1, "User1", "User1"),
                PostApiModel(2, 2, "User2", "User2"),
                PostApiModel(3, 3, "User3", "User3"),
                PostApiModel(4, 4, "User4", "User4"),
            )
        )
    }*/


}

class RetrofitApiClient : ApiClient {

    private val urlEndPoint: String = "https://jsonplaceholder.typicode.com/"
    private var apiEndPoint: ApiEndPoint

    init {
        apiEndPoint = buildApiService()
    }

    private fun buildApiService(): ApiEndPoint {
        return buildClient().create(ApiEndPoint::class.java)
    }

    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    override fun getUsers(): List<UserApiModel> {
        val call = apiEndPoint.getUsers()
        val response = call.execute()
        if (response.isSuccessful) {
            val users = response.body()
            return users ?: mutableListOf()
        } else {
            return mutableListOf()
        }
    }

    override fun getUsers(callback: ApiCallback<List<UserApiModel>>) {
        val call = apiEndPoint.getUsers()
        call.enqueue(object : Callback<List<UserApiModel>> {
            override fun onResponse(
                call: Call<List<UserApiModel>>,
                response: Response<List<UserApiModel>>
            ) {
                if (response.isSuccessful) {
                    val users = response.body()
                    callback.onResponse(users ?: mutableListOf())
                } else {
                    callback.onResponse(mutableListOf())
                }
            }

            override fun onFailure(call: Call<List<UserApiModel>>, t: Throwable) {
                callback.onFailure(t.message ?: "Error in response")
            }
        })
    }

    override fun getUser(userId: Int): UserApiModel? {
        val call = apiEndPoint.getUser(userId)
        val response = call.execute()
        if (response.isSuccessful) {
            val user = response.body()
            return user
        } else {
            return null
        }
    }

    override fun getPost(): List<PostApiModel> {
        val call = apiEndPoint.getPost()
        val response = call.execute()
        return if (response.isSuccessful) {
            response.body() ?: mutableListOf()
        } else {
            mutableListOf()
        }
    }

    /*override fun getPost(callback: ApiCallback<List<PostApiModel>>) {
        val call = apiEndPoint.getUsers()
        call.enqueue(object : Callback<List<PostApiModel>> {
            override fun onResponse(
                call: Call<List<PostApiModel>>,
                response: Response<List<PostApiModel>>
            ) {
                if (response.isSuccessful) {
                    val users = response.body()
                    callback.onResponse(users ?: mutableListOf())
                } else {
                    callback.onResponse(mutableListOf())
                }
            }

            override fun onFailure(call: Call<List<PostApiModel>>, t: Throwable) {
                callback.onFailure(t.message ?: "Error in response")
            }
        })
    }*/

}


