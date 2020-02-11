package com.example.stackoverflowuser.data.remote

import com.example.stackoverflowuser.data.remote.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SOService {
    @GET("/users?site=stackoverflow")
    suspend fun getUsers(@Query("page") page: Int, @Query("pagesize") pageSize: Int): UserResponse
}