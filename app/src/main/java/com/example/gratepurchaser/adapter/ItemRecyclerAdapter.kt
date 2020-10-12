package com.example.gratepurchaser.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.gratepurchaser.R

class ItemRecyclerAdapter (val context: Context, val lists: ArrayList<String>): RecyclerView.Adapter<ItemRecyclerAdapter.ViewHolder>() {
    class ViewHolder (itemview : View) : RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_row,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = lists.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

//        holder.itemView.color_detail_list.text = H.arrayPnameColor[position]
//        holder.itemView.setOnClickListener {
//            Log.d("my","pid : ${H.arrayPcolor[position]}, vid : ${H.arrayVcolor[position]}")
//            Toast.makeText(context, "pid : ${H.arrayPcolor[position]}, vid : ${H.arrayVcolor[position]}", Toast.LENGTH_SHORT).show()
//        }
    }
}
