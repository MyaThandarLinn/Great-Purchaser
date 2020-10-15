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
import kotlinx.android.synthetic.main.detail_cat_value_row.view.*
import kotlinx.android.synthetic.main.size_detail_item.view.*

class DetailAdapter (val context: Context, val detailList: List<String>): RecyclerView.Adapter<DetailAdapter.ViewHolder>() {
    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.size_detail_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = detailList.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.size_detail_list.text = H.resultList[position]

        holder.itemView.setOnClickListener {
            H.chkPVid.add(H.arypvid[position])  // need // for adding click id
            H.chkValue.add(H.keyValue)

//            Toast.makeText(context, "${H.resultList[position]}", Toast.LENGTH_SHORT).show()

//            Log.d("hello","ary value position : ${H.aryValue[position]}")
//            Log.d("hello","ary value : ${H.aryValue}")

//            for (y in 0..H.aryValue.size - 1) {
//                if (H.resultList[position] in H.aryValue[y].second){
//                    Log.d("hello","value -> ${H.aryValue[y].first}")
//                }
//            }


//            Log.d("hello","check pvid : ${H.arypvid[position]}")
//            Log.d("hello","click pvid : ${H.chkPVid}")
//            Log.d("hello","click values : ${H.chkValue}")
//            Log.d("hello","click values : ${H.keyValue}")

//            for (x in 0..H.aryValue.size-1){
//                Log.d("hello","aryValue : ${H.aryValue[x].first}")
//            }
        }

//        var group : List<Pair<String,String>> = listOf()
//
//        group = H.chkValue.zip(H.chkPVid)
//        Log.d("hello","group : $group")
//        if (H.chkPVid.size > H.resultList.count()){
//            Log.d("hello","${H.chkPVid} > ${H.resultList.count()}")
//        }
//        Log.d("hello","array item : ${H.chkPVid}")
    }

}
