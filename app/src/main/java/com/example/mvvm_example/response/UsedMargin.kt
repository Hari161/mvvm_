package com.example.mvvm_example.response

data class UsedMargin(
    var isDisp: String,
    var name: String,
    var subList: List<Sub>,
    var value: String
)