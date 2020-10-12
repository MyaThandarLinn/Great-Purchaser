package com.example.gratepurchaser.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Slide (
    @SerializedName("image")
    val image: String,

    @SerializedName("title")
    val title:String
): Serializable