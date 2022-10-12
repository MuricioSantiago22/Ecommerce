package com.example.e_commerce.data.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id") val id: String = "",
    @SerializedName("title") val title: String = "",
    @SerializedName("short_description") val shortDescription: String = "",
    @SerializedName("price") val price: String = "",
    @SerializedName("discount") val discount: String= "",
    @SerializedName("image_url") val imageUrl: String = "",
    @SerializedName("description") val description: String = ""
)



