package com.example.mvvm_image

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_image.repository.Repository
import com.example.mvvm_image.response.ImageResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    var myCustomPosts: MutableLiveData<Response<ImageResponse>> = MutableLiveData()

    fun getCustomPosts() {
        viewModelScope.launch {
            val response = repository.getCustomPosts()
            myCustomPosts.postValue(response)
        }
    }

}