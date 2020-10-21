package com.example.gratepurchaser.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gratepurchaser.R
import com.example.gratepurchaser.libby.H
import kotlinx.android.synthetic.main.size_detail_item.view.*

class DetailAdapter(
    val context: Context,
    private val detailList: List<String>,
    private val cellClickListener: CellClickListener
)
    : RecyclerView.Adapter<DetailAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.size_detail_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = detailList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val data = detailList[position]

        holder.itemView.size_detail_list.text = H.resultList[position]

        Log.d("hello","keyValue ${H.keyValue}")
        Log.d("hello","result List : ${H.resultList[position]}")

        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(data)
        }
    }
}

//               Log.d("hello","resultList ${H.keyValue}-> ${H.resultList[position]}")

//            Toast.makeText(context, "resultList ${H.keyValue}-> ${H.resultList[position]}", Toast.LENGTH_SHORT).show()
