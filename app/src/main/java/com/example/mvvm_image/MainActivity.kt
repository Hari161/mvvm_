package com.example.mvvm_image

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_image.repository.Repository
import android.net.ConnectivityManager
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_image.adapter.AdapterAlbum
import com.example.mvvm_image.response.ImageResponse
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),AdapterAlbum.OnItemClickListener {
    private lateinit var viewModel: MainViewModel
    private var responseImage : ImageResponse ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rc_view.layoutManager = LinearLayoutManager(this)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        if (checkNet())
            setValue()
        else
            Toast.makeText(this, "No Internet Access", Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        if(checkNet()){
            responseImage?.let { setAdapter(it) }
        }else  Toast.makeText(this, "No Internet Access", Toast.LENGTH_LONG).show()
    }

    private fun setValue() {
        viewModel.getCustomPosts()
        viewModel.myCustomPosts.observe(this, Observer { response ->
            if (response.isSuccessful) {
                responseImage = response.body()
                response.body()?.let { setAdapter(it) }
                Log.d("check resp", response.body().toString())
            } else {
                Toast.makeText(this, "failed", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun checkNet(): Boolean {
        val connectivityManager = this.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo!!.isConnected;
    }

    private fun setAdapter(image : ImageResponse){
        val adapter = AdapterAlbum(image,this,this)
        rc_view.adapter = adapter
        rc_view.adapter?.notifyDataSetChanged()
    }

    override fun onItemClick(removeIndex: Int,album_id : Int) {
        Toast.makeText(this, "Album id :${album_id} deleted", Toast.LENGTH_SHORT).show()
        responseImage?.removeAt(removeIndex)
        responseImage?.let { setAdapter(it) }
        if(responseImage == null){
            rc_view.visibility= View.GONE
            no_data_tv.visibility = View.VISIBLE
        }
    }

}