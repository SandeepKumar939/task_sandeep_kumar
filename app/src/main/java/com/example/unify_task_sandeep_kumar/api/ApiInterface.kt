package com.example.unify_task_sandeep_kumar.api

import com.example.unify_task_sandeep_kumar.model.User
import retrofit2.Response
import retrofit2.http.GET


interface ApiInterface {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>

}