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

        when (position) {
            0 -> return WomenFragment()
            1 -> return FavouriteFragment()
            2 -> return WomenFragment()
            3 -> return FavouriteFragment()
            4 -> return WomenFragment()
            5 -> return FavouriteFragment()
            6 -> return WomenFragment()
            else -> return AccountFragment()
        }
    }

    override fun getCount(): Int {
        return tabCount
    }
}