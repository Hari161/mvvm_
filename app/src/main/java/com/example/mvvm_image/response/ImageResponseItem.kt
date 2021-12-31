package com.example.mvvm_image.response

data class ImageResponseItem(
    var albumId: Int,
    var id: Int,
    var thumbnailUrl: String,
    var title: String,
    var url: String
)