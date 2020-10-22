package com.example.gratepurchaser.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gratepurchaser.R
import com.example.gratepurchaser.libby.H
import kotlinx.android.synthetic.main.detail_cat_value_row.view.*
import kotlinx.android.synthetic.main.size_detail_item.view.*

class CustomDetailAdapter (val context: Context,
                           private val allCategory: ArrayList<String>)
    : RecyclerView.Adapter<CustomDetailAdapter.MainViewHolder>(), CellClickListener {

//    var first  = ArrayList<String>()
//    var uFirst = ArrayList<String>()
//    var usecond = ArrayList<String>()


    class MainViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.detail_cat_value_row, parent, false))
    }

    override fun getItemCount(): Int = allCategory.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        holder.itemView.txt_property_name.text = H.arrayPtrueName[position]

        for (x in H.aryValue.indices){
            when(H.arrayPtrueName[position]){
                H.aryValue[x].first -> {
                    H.keyValue = H.aryValue[x].first
                    val result = H.aryValue[x].second
                    H.resultList = result
                    H.chkValue = listOf(H.aryValue[x].first)
                    detailCatRecycler(holder.itemView.detail_main_recycler,H.resultList, this, H.keyValue)
                }
            }
        }
    }

    private fun detailCatRecycler(recyclerView: RecyclerView , customItem: List<String>,
                                  clickListener: CellClickListener, str : String){
        val itemAdapter = DetailAdapter(context, customItem, clickListener, str)
        recyclerView.adapter = itemAdapter
        recyclerView.layoutManager = GridLayoutManager(context,2, LinearLayoutManager.VERTICAL,false)
    }

    override fun onCellClickListener(data: String, id: String, key: String) {

        Toast.makeText(context, "$key -> $data -> $id", Toast.LENGTH_SHORT).show()
        H.aryTestId.add(id)
        H.aryTestName.add(key)
        val zip = H.aryTestName.zip(H.aryTestId)

        // for get only one id when i click body color many time, this will filter only one body color// first one
        // error // clean
        for (i in zip.indices){
            val temp = zip[i]
            H.first.add(zip[i].first)

            if (temp.first in H.uFirst){
                // do nothing
            }else{
                if (H.uFirst.size < H.arrayPtrueName.size){
                    H.uFirst.add(temp.first)
                    H.uSecond.add(temp.second)
                }else{
                    H.uFirst.clear()
                    H.uSecond.clear()
                    H.uFirst.add(temp.first)
                    H.uSecond.add(temp.second)
                }
            }
        }
        Log.d("hello","ufirst -> ${H.uFirst}, usecond -> ${H.uSecond}")
        H.text = data
    }
}

interface CellClickListener {
    fun onCellClickListener(data : String, id: String, key : String)
}