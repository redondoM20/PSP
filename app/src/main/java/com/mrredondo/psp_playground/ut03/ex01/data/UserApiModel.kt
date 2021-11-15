package com.mrredondo.psp_playground.ut03.ex01.data

data class UserApiModel(val id: Int, val name: String, val username: String, val email: String)

data class PostApiModel(val userId: Int, val id: Int, val title: String, val body: String)