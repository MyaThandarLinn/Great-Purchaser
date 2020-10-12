package com.example.gratepurchaser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gratepurchaser.adapter.FViewPageAdapter
import com.example.gratepurchaser.fragment.*
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()

        // for tab fragment
        setUpTabs()
    }

    private fun setUpTabs() {
        val adapter = FViewPageAdapter(supportFragmentManager)

        adapter.addFragment(HomeFragment(),"")
        adapter.addFragment(FavouriteFragment(),"")
        adapter.addFragment(CategoryFragment(),"")
        adapter.addFragment(ShoppingCartFragment(),"")
        adapter.addFragment(AccountFragment(),"")

        fragment_viewpager.adapter = adapter
        home_tabs.setupWithViewPager(fragment_viewpager)

        // set icons which you wanna add to tablayout
        home_tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home)
        home_tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_favorite)
        home_tabs.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_category_24)
        home_tabs.getTabAt(3)!!.setIcon(R.drawable.ic_baseline_shopping_cart)
        home_tabs.getTabAt(4)!!.setIcon(R.drawable.ic_baseline_person)
    }
}