package com.example.mvvm_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_example.repository.Repository
import com.example.mvvm_example.request.Data
import com.example.mvvm_example.request.Echo
import com.example.mvvm_example.request.PostDataReqst
import com.example.mvvm_example.request.Request
import com.example.mvvm_example.response.BottomSheetSubList
import com.example.mvvm_example.response.PostDataResponse
import com.example.mvvm_example.response.Sub
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    val bottomsheet = BottomSheetSubList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getCustomPosts()

        viewModel.myCustomPosts.observe(this, Observer { response ->
            if (response.isSuccessful) {
                setResponseData(response)
                Log.d("check resp", response.body().toString())
            } else {
                Toast.makeText(this, "failed", Toast.LENGTH_LONG).show()
            }
        })


    }

    private fun setResponseData(respValue: Response<PostDataResponse>){
        respValue.body()?.let {
            if(it.response.data.avilableMargin.isDisp == "Y"){
                availableMarginLabel.text = it.response.data.avilableMargin.name
                availableMarginValue.text = this.getString(R.string.AE_RUPEES_SYMBOL_Value,it.response.data.avilableMargin.value)
            }
            if(it.response.data.totalMargin.isDisp == "Y")
                totalMarginValue.text = it.response.data.totalMargin.value
            if(it.response.data.funds.isDisp == "Y")
                fundsValue.text = it.response.data.funds.value
            if(it.response.data.holdings.isDisp == "Y")
                holdingsValue.text = it.response.data.holdings.value
            if(it.response.data.usedMargin.isDisp == "Y")
                usedMarginValue.text = it.response.data.usedMargin.value

        }
        fundsLabel.setOnClickListener {
            respValue.body()?.response?.data?.funds?.let { it1 -> setAdapter(it1.name,it1.value,it1.subList) }
        }
        usedMarginLabel.setOnClickListener {
            respValue.body()?.response?.data?.usedMargin?.let { it1 -> setAdapter(it1.name,it1.value,it1.subList) }
        }
    }
    private fun setAdapter(heading: String, dispValue: String, listSub :List<Sub>){
        BottomSheetSubList.setBottomsheetValue(heading,dispValue,listSub)
        bottomsheet.show(supportFragmentManager,"bottomsheet")
    }

}