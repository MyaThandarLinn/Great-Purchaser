package com.example.gratepurchaser.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.gratepurchaser.fragment.AccountFragment
import com.example.gratepurchaser.fragment.FavouriteFragment
import com.example.gratepurchaser.fragment.WomenFragment


class TabPagerAdapter(fm: FragmentManager, private var tabCount: Int) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {

        return when (position) {
            0 -> WomenFragment()
            1 -> FavouriteFragment()
            2 -> WomenFragment()
            3 -> FavouriteFragment()
            4 -> WomenFragment()
            5 -> FavouriteFragment()
            6 -> WomenFragment()
            else -> AccountFragment()
        }
    }

    override fun getCount(): Int {
        return tabCount
    }
}