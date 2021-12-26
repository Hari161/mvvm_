package com.example.mvvm_example

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_example.repository.Repository
import com.example.mvvm_example.request.Data
import com.example.mvvm_example.request.Echo
import com.example.mvvm_example.request.PostDataReqst
import com.example.mvvm_example.request.Request
import com.example.mvvm_example.response.PostDataResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    var myCustomPosts: MutableLiveData<Response<PostDataResponse>> = MutableLiveData()

    fun getCustomPosts() {
        viewModelScope.launch {
            val response = repository.getCustomPosts((PostDataReqst(
                    echo = Echo(RequestDataGet.GetValue().SpinnerItem), request = Request(
                    RequestDataGet.GetValue().appId, Data(
                    RequestDataGet.GetValue().grpId,RequestDataGet.GetValue().sessionId,
                    RequestDataGet.GetValue().type,RequestDataGet.GetValue().usrCode,RequestDataGet.GetValue().usrID
            ), formFactor = RequestDataGet.GetValue().formFactor, futures = RequestDataGet.GetValue().futures, response_format = RequestDataGet.GetValue().response_format
            )
            )))
            myCustomPosts.postValue(response)
        }
    }

}