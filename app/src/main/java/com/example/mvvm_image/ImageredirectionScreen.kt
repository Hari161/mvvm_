package com.example.mvvm_image

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_imageredirection_screen.*

class ImageredirectionScreen : AppCompatActivity() {
    var imgurl :String ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imageredirection_screen)
        intent.getStringExtra("urlLink")?.let { webview.loadUrl(it)
            imgurl = it}
    }

    override fun onResume() {
        super.onResume()
        imgurl?.let { webview.loadUrl(it) }
    }
}