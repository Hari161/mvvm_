package com.example.mvvm_example.response

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_example.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet.*

class BottomSheetSubList: BottomSheetDialogFragment(){
    lateinit var activity: Activity
companion object getVal{
    private var heading :String ?=null
    private var dispValue :String ?=null
    var subList: List<Sub>? = emptyList()
    fun setBottomsheetValue(heading: String, dispValue: String, listSub :List<Sub>){
        this.heading = heading
        this.dispValue = dispValue
        this.subList = listSub
    }
}
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.bottom_sheet, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mainHeading_tv.text = heading
        mainHeading_value_tv.text = dispValue
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val adapter = subList?.let { MyAdapter(it) }
        recyclerView.adapter = adapter
        recyclerView.adapter?.notifyDataSetChanged()
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Activity)
            activity = context
    }
    class MyAdapter(private val mList: List<Sub>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_layout, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(mList[position].isDisp == "Y") {
            holder.headingView.text = mList[position].name
            holder.valueView.text = mList[position].value
        }else{
            holder.headingView.visibility =View.GONE
            holder.valueView.visibility =View.GONE
        }
        }

        override fun getItemCount(): Int {
            return mList.size
        }
        class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
            val headingView: TextView = itemView.findViewById(R.id.value_txt)
            val valueView: TextView = itemView.findViewById(R.id.set_value_id_txt)
        }
    }
}
