package com.example.gratepurchaser.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gratepurchaser.R
import com.example.gratepurchaser.model.HistoryModel
import com.example.gratepurchaser.profile.HistoryDetailActivity

class HistoryAdapter(var context: Context, var arrayList: ArrayList<HistoryModel>)
    : RecyclerView.Adapter<HistoryAdapter.ItemHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.history_cardview, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun getItemCount(): Int = arrayList.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val list = arrayList[position]

        holder.current.text = list.current.toString()
        holder.subtract.text = list.subtract.toString()
        holder.note.text = list.note
        holder.remain.text = list.remain.toString()
        holder.date.text = list.date

        holder.itemView.setOnClickListener {
            context.startActivity(Intent(holder.itemView.context,HistoryDetailActivity::class.java))
        }

    }

    class ItemHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        var current : TextView = itemView.findViewById(R.id.his_current)
        var subtract : TextView = itemView.findViewById(R.id.his_subtract)
        var note : TextView = itemView.findViewById(R.id.his_note)
        var remain : TextView = itemView.findViewById(R.id.his_remain)
        var date : TextView = itemView.findViewById(R.id.his_date)
    }
}