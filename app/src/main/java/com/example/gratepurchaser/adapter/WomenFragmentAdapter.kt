package com.example.gratepurchaser.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.gratepurchaser.R
import com.example.gratepurchaser.model.WomenModel

class WomenFragmentAdapter(var context: Context, var arrayList: ArrayList<WomenModel>)
    :RecyclerView.Adapter<WomenFragmentAdapter.ItemHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.women_frag_cardview, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun getItemCount(): Int = arrayList.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

      val list = arrayList[position]

        holder.icons.setImageResource(list.iconChar!!)
        holder.title.text = list.titleChar

        holder.title.setOnClickListener {
            Toast.makeText(context, "hello title", Toast.LENGTH_SHORT).show()
        }
    }

    class ItemHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        var icons : ImageView = itemView.findViewById(R.id.women_item_image)
        var title : TextView = itemView.findViewById(R.id.women_item_title)
    }
}