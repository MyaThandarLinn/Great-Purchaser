package com.example.gratepurchaser.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gratepurchaser.R
import com.example.gratepurchaser.model.AttributesModel
import kotlinx.android.synthetic.main.recycler_row.view.*

class AttributeAdapter (val context: Context, val lists: List<AttributesModel>) :
    RecyclerView.Adapter<AttributeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.recycler_row, p0, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = lists.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val sm = lists[p1]

      //  p0.itemView.property_name.text = sm.PropertyName

        when (sm.IsConfigurator) {
            "true" -> p0.itemView.property_name.text = sm.PropertyName
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}