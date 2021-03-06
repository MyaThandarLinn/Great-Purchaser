package com.example.gratepurchaser.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gratepurchaser.R
import com.example.gratepurchaser.libby.H
import kotlinx.android.synthetic.main.cat_main_row.view.*
import kotlinx.android.synthetic.main.color_detail_item.view.*
import kotlinx.android.synthetic.main.detail_cat_value_row.view.*
import kotlinx.android.synthetic.main.size_detail_item.view.*

class CustomMainAdapter (val context: Context, private val allCategory: ArrayList<String>)
    : RecyclerView.Adapter<CustomMainAdapter.MainViewHolder>() {

    class MainViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.cat_main_row, parent, false))
    }

    override fun getItemCount(): Int = allCategory.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.itemView.txt_name.text = H.arrayPtrueName[position]

        when(H.arrayPtrueName[position]){
            H.aryValue[position].first -> {
                val result = H.aryValue[position].second
                H.resultList = result
                detailCatRecycler(holder.itemView.main_recycler,H.resultList)
            }
        }
    }

    private fun detailCatRecycler(recyclerView: RecyclerView, customItem: List<String>){
        val itemAdapter = CustomAdapter(context, customItem)
        recyclerView.adapter = itemAdapter
        recyclerView.layoutManager = GridLayoutManager(context,2, LinearLayoutManager.VERTICAL,false)
    }
}