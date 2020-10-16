package com.example.gratepurchaser.fragment

import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gratepurchaser.R
import com.example.gratepurchaser.profile.FolderActivity
import com.example.gratepurchaser.profile.HistoryActivity
import com.example.gratepurchaser.profile.WarehouseActivity
import kotlinx.android.synthetic.main.fragment_account.*


class AccountFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        go_to_history.setOnClickListener {
            startActivity(Intent(view.context, HistoryActivity::class.java))
        }

        go_to_folder.setOnClickListener {
            startActivity(Intent(view.context, FolderActivity::class.java))
        }

        go_to_warehouse.setOnClickListener {
            startActivity(Intent(view.context, WarehouseActivity::class.java))
        }
    }
}