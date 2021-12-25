package com.example.mvvm_example.repository

import com.example.mvvm_example.api.RetrofitInstance
import com.example.mvvm_example.request.PostDataReqst
import com.example.mvvm_example.response.PostDataResponse
import retrofit2.Response

class Repository {

    suspend fun getCustomPosts(reqst : PostDataReqst): Response<PostDataResponse> {
        return RetrofitInstance.api.setRequest(reqst)
    }

}