package com.example.gratepurchaser.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gratepurchaser.R
import com.example.gratepurchaser.libby.H
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_detail_image_slider.view.*

class ItemSliderAdapter (val context: Context, val albums: ArrayList<String>): RecyclerView.Adapter<ItemSliderAdapter.ViewHolder>() {
    class ViewHolder (itemview : View) : RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_detail_image_slider,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = albums.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(H.image_slider[position]).into(holder.itemView.item_detail_image_slide)
    }
}
