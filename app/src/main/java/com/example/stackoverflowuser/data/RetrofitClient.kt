package com.example.stackoverflowuser.data

import com.example.stackoverflowuser.data.remote.SOService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val retrofit: Retrofit by lazy { createRetrofit() }
    val soService: SOService by lazy { createSoService() }

    private const val BASE_URL = "https://api.stackexchange.com/2.2/"

    private fun createRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

    private fun createSoService(): SOService = retrofit.create(SOService::class.java)
}