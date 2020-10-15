package com.example.gratepurchaser.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gratepurchaser.R
import com.example.gratepurchaser.activity.ItemDetailActivity
import com.example.gratepurchaser.libby.H
import com.example.gratepurchaser.model.Image
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.album_row.view.*
import org.jetbrains.anko.startActivity

class AlbumAdapter(val context: Context, val albums: List<Image>): RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {
    class ViewHolder (itemview : View) : RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.album_row,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = albums.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = albums[position]
        holder.itemView.item_title.text = album.title
        Picasso.get().load(album.thumbnailUrl).into(holder.itemView.item_image)
        holder.itemView.item_url.text = album.url

        holder.itemView.setOnClickListener {
            // when i click image , it go to next activity (* notice -> go activity form adapter)
        //    val intent = Intent(holder.itemView.context, ItemDetailActivity::class.java)

            //get album data and store in H ,to set ItemDetailActivity
            H.item_d_album_title = album.title
            H.item_d_album_id = album.id.toString()
            H.item_d_album_image = album.thumbnailUrl

            //this is for ItemDetailActivity's detail data change
            context.startActivity<ItemDetailActivity>()
        }
    }

}
