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
import com.example.gratepurchaser.model.AttributesModel
import kotlinx.android.synthetic.main.detail_cat_value_row.view.*
import kotlinx.android.synthetic.main.size_detail_item.view.*

class DetailAdapter (val context: Context, val detailList: List<String>): RecyclerView.Adapter<DetailAdapter.ViewHolder>() {
    class ViewHolder (itemview : View) : RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.size_detail_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = detailList.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.size_detail_list.text = H.resultList[position]
        holder.itemView.setOnClickListener {
//            var vid = H.arrayVid[position]
//            var pid = H.aryPid[position]
            Toast.makeText(context, "vid: ${H.aryVid[position]} , pid: ${H.aryPid[position]}", Toast.LENGTH_SHORT).show()
        }
    }

}
