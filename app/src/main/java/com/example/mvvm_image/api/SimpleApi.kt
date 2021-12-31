package com.example.mvvm_image.api

import com.example.mvvm_image.response.ImageResponse
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("photos")
    suspend fun setRequest(): Response<ImageResponse>

}