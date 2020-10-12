package com.example.gratepurchaser.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.gratepurchaser.R
import com.example.gratepurchaser.libby.H
import kotlinx.android.synthetic.main.color_detail_item.view.*
import kotlinx.android.synthetic.main.size_detail_item.view.*

class CustomItemDetailAdapter (val context: Context, val sizelists: ArrayList<String>): RecyclerView.Adapter<CustomItemDetailAdapter.ViewHolder>() {
    class ViewHolder (itemview : View) : RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.size_detail_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = sizelists.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.size_detail_list.text = H.arrayPnameSize[position]
        holder.itemView.setOnClickListener {
            Toast.makeText(context, "pid : ${H.arrayPsize[position]}, vid : ${H.arrayVsize[position]}", Toast.LENGTH_SHORT).show()
        }
    }
}