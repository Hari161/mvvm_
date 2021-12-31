package com.example.mvvm_image.repository

import com.example.mvvm_image.api.RetrofitInstance
import com.example.mvvm_image.response.ImageResponse
import retrofit2.Response

class Repository {

    suspend fun getCustomPosts(): Response<ImageResponse> {
        return RetrofitInstance.api.setRequest()
    }
}
