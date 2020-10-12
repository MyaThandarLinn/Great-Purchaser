package com.example.gratepurchaser.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.gratepurchaser.R

class CustomDialogFragment : DialogFragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //this is for dialog fragment return
   return (inflater.inflate(R.layout.activity_custom_dialog_fragment, container, false))
    }
}