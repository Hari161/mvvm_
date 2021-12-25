package com.example.mvvm_example

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_example.repository.Repository
import com.example.mvvm_example.request.PostDataReqst
import com.example.mvvm_example.response.PostDataResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    var myCustomPosts: MutableLiveData<Response<PostDataResponse>> = MutableLiveData()

    fun getCustomPosts(reqst: PostDataReqst) {
        viewModelScope.launch {
            val response = repository.getCustomPosts(reqst)
            myCustomPosts.value = response
        }
    }

}