package com.example.gratepurchaser.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DataModel(
    @SerializedName("items")
    val items: List<Slide>,

    @SerializedName("status")
    val status: String
): Serializable