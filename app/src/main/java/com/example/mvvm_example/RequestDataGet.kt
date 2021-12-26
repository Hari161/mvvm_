package com.example.mvvm_example

sealed class RequestDataGet {
    class GetValue : RequestDataGet() {
        val SpinnerItem: String = "All Segments"
        val appId: String = "0cae918bfdfb10db2869fd86858d962a"
        val grpId: String = "ANGEL"
        val sessionId: String ="eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NDA1MjkyNjgsImlhdCI6MTY0MDQ5MzI2OCwib21uZW1hbmFnZXJpZCI6MSwic3ViIjoiSDg4ODg5In0.t-6I_EApZic9SCIMGrtzSh2d3_RZJ7i-ZajdC-r1j9IkMg89KeN-G6Cp88VOj_etuo2gwanb78JFNBLiqPhxeQ"
        val type: String = "All Segments"
        val usrCode: String = ""
        val usrID: String = "H88889"
        val formFactor: String = "M"
        val futures: String = "0"
        val response_format: String = "json"
    }
}