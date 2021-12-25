package com.example.mvvm_example.request

data class Request(
    var appID: String,
    var data: Data,
    var formFactor: String,
    var futures: String,
    var response_format: String
)