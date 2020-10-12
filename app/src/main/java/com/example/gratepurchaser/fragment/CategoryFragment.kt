package com.example.gratepurchaser.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gratepurchaser.R
import com.example.gratepurchaser.adapter.TabPagerAdapter
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        category_tabs.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        configureTabLayout()
    }

    private fun configureTabLayout() {
        category_tabs.addTab(category_tabs.newTab().setText("Men"))
        category_tabs.addTab(category_tabs.newTab().setText("women"))
        category_tabs.addTab(category_tabs.newTab().setText("Boys"))
        category_tabs.addTab(category_tabs.newTab().setText("Girls"))
        category_tabs.addTab(category_tabs.newTab().setText("Clothes"))
        category_tabs.addTab(category_tabs.newTab().setText("Dress"))
        category_tabs.addTab(category_tabs.newTab().setText("Shoes"))

        val adapter = TabPagerAdapter(activity!!.supportFragmentManager,
            category_tabs.tabCount)
        category_viewPager.adapter = adapter

        category_viewPager.addOnPageChangeListener(
            TabLayout.TabLayoutOnPageChangeListener(category_tabs))
        category_tabs.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                category_viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }

}