package com.example.gratepurchaser.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gratepurchaser.R
import com.example.gratepurchaser.adapter.HistoryAdapter
import com.example.gratepurchaser.adapter.WomenFragmentAdapter
import com.example.gratepurchaser.model.HistoryModel
import com.example.gratepurchaser.model.WomenFragentModel
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.fragment_women.*

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        supportActionBar?.hide()

        val gridLayoutManager = GridLayoutManager(this,1, LinearLayoutManager.VERTICAL,false)
        history_recyclerView.layoutManager = gridLayoutManager

        val arrayList  = setDataInitList()
        val adapter = HistoryAdapter(this, arrayList)
        history_recyclerView.adapter = adapter
    }

    fun setDataInitList(): ArrayList<HistoryModel>{
        var items : ArrayList<HistoryModel> = ArrayList()

        items.add(HistoryModel(120000,150000,5000,"hello","9.23"))
        items.add(HistoryModel(120000,150000,5000,"hello","9.23"))
        items.add(HistoryModel(120000,150000,5000,"hello","9.23"))

        return items
    }
}