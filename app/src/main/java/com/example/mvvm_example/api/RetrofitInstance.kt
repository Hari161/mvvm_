package com.example.mvvm_example.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
        val BASE_URL = "https://mprod-ws.angelbroking.com/"
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }

}