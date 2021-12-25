package com.example.mvvm_example.response

data class Response(
    var appID: String,
    var `data`: Data,
    var infoID: String,
    var msgID: String,
    var serverTime: String,
    var svcGroup: String,
    var svcName: String,
    var svcVersion: String
)