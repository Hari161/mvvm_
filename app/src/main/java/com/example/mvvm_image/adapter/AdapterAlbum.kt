package com.example.mvvm_image.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm_image.ImageredirectionScreen
import com.example.mvvm_image.R
import com.example.mvvm_image.response.ImageResponseItem

class AdapterAlbum(
        val albumList: ArrayList<ImageResponseItem>,
        val context: Context,
        val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<AdapterAlbum.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.main_lay_cl.setOnClickListener {
            val intent = Intent(context, ImageredirectionScreen::class.java)
            intent.putExtra("urlLink", albumList[position].thumbnailUrl)
            context.startActivity(intent)
        }
        holder.delete_btn.setOnClickListener {
            onItemClickListener.onItemClick(position, albumList[position].id)
        }
        holder.album_id.text = albumList[position].albumId.toString()
        holder.id.text = albumList[position].id.toString()
        holder.title.text = albumList[position].title
        holder.image.loadUrl(albumList[position].url)
    }

    override fun getItemCount(): Int {
        return albumList.size
    }

    interface OnItemClickListener {
        fun onItemClick(removeIndex: Int, album_id: Int)

    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val delete_btn: TextView = itemView.findViewById(R.id.delete_tv)
        val album_id: TextView = itemView.findViewById(R.id.album_value_tv)
        val id: TextView = itemView.findViewById(R.id.id_value_tv)
        val title: TextView = itemView.findViewById(R.id.title_value_tv)
        val image: WebView = itemView.findViewById(R.id.imgae_iv)
        val main_lay_cl: ConstraintLayout = itemView.findViewById(R.id.main_lay_cl)
    }
}