package com.example.e_commerce.data.network


import com.example.e_commerce.data.model.Product
import com.example.e_commerce.data.model.ProductResponse


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface WebServiceProductList {
    @GET("products")
    suspend fun getAllProductsList(@Query("X-API-KEY") apiKey: String):Response<ProductResponse>
}



    




