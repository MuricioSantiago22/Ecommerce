package com.example.e_commerce.data.model

import com.google.gson.annotations.SerializedName

data class ProductResponse (
    @SerializedName("response") val response: List<Product>? = null
        )