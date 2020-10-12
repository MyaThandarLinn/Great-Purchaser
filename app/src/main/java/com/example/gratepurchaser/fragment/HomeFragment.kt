package com.example.gratepurchaser.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gratepurchaser.R
import com.example.gratepurchaser.adapter.AlbumAdapter
import com.example.gratepurchaser.adapter.SliderViewpagerAdapter
import com.example.gratepurchaser.model.Image
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

@Suppress("UNREACHABLE_CODE")
class HomeFragment : Fragment() {

    //this is for image slider in viewPager
    var image : Array<Int> = arrayOf(R.drawable.one, R.drawable.two, R.drawable.three)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // this is for cardView
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
          viewPage.adapter = SliderViewpagerAdapter(context!!.applicationContext,image)

        // this is for cardView
        doAsync {
            val jsons = URL("https://jsonplaceholder.typicode.com/photos").readText()


            uiThread {
                val albums = Gson().fromJson(jsons,Array<Image>::class.java).toList()

                val layoutManager = GridLayoutManager(context,2) as RecyclerView.LayoutManager
                item_recyclerView.layoutManager = layoutManager

                val adapter = AlbumAdapter(activity!!, albums)
                item_recyclerView.adapter = adapter

                home_fragment_progress.visibility = View.GONE
            }
        }
    }

}