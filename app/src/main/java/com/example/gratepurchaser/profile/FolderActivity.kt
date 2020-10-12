package com.example.gratepurchaser.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gratepurchaser.R

class FolderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_folder)

        supportActionBar?.hide()
    }
}