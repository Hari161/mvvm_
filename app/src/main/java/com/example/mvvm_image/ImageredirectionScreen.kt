package com.example.mvvm_image

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_imageredirection_screen.*

class ImageredirectionScreen : AppCompatActivity() {
   private var imgurl :String ?=null
   private var removeIndex :Int ?=null
   private var album_id :Int ?=null
    private lateinit var alrtBuilder :AlertDialog.Builder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imageredirection_screen)
        intent.getStringExtra("urlLink")?.let { webview.loadUrl(it)
            imgurl = it}
        removeIndex = intent.getStringExtra("position")?.toInt()
        album_id = intent.getStringExtra("album_id")?.toInt()
        delet_tv.setOnClickListener { AlertClick() }
    }

    override fun onResume() {
        super.onResume()
        imgurl?.let { webview.loadUrl(it) }
    }

    private fun AlertClick() {
        alrtBuilder = AlertDialog.Builder(this)
                    alrtBuilder.setTitle("Alert!")
                    .setMessage("Do you want to Delete ?")
                    .setCancelable(true) // dialog box in cancellable
                    .setPositiveButton("Yes"){dialogInterface,it ->
                        val intent = Intent(this,MainActivity::class.java)
                        intent.putExtra("remove_ind", removeIndex)
                        intent.putExtra("album_id", album_id)
                        setResult(RESULT_OK, intent);
                        finish()
                    }
                    .setNegativeButton("No"){dialogInterface,it ->
                        dialogInterface.cancel()
                    }
                    .show()
        }
}