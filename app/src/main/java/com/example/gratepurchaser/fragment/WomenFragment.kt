package com.example.gratepurchaser.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gratepurchaser.R
import com.example.gratepurchaser.adapter.AlbumAdapter
import com.example.gratepurchaser.adapter.WomenFragmentAdapter
import com.example.gratepurchaser.model.WomenFragentModel
import kotlinx.android.synthetic.main.fragment_women.*

class WomenFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_women, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val gridLayoutManager = GridLayoutManager(context,2, LinearLayoutManager.VERTICAL,false)
        women_fragment_recycler.layoutManager = gridLayoutManager

        val arrayList  = setDataInitList()
        val adapter = WomenFragmentAdapter(activity!!, arrayList)
        women_fragment_recycler.adapter = adapter
    }

    fun setDataInitList(): ArrayList<WomenFragentModel>{
       var items : ArrayList<WomenFragentModel> = ArrayList()

        items.add(WomenFragentModel(R.drawable.ic_account_balance,"Account"))
        items.add(WomenFragentModel(R.drawable.ic_baseline_category_24,"Category"))
        items.add(WomenFragentModel(R.drawable.ic_baseline_favorite,"Favourite"))
        items.add(WomenFragentModel(R.drawable.ic_baseline_home,"Home"))
        items.add(WomenFragentModel(R.drawable.ic_baseline_message,"Message"))
        items.add(WomenFragentModel(R.drawable.ic_baseline_share,"Share"))
        items.add(WomenFragentModel(R.drawable.ic_baseline_shopping_cart,"Shopping"))

        return items
    }

}