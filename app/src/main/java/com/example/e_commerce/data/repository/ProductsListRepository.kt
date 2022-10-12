package com.example.e_commerce.data.repository
import com.example.e_commerce.data.model.Product
import com.example.e_commerce.data.model.ProductResponse
import com.example.e_commerce.data.network.ProductsListDataSource


class ProductsListRepository {

    private val api = ProductsListDataSource()


    suspend fun getAllProductsList(): ProductResponse{
        val response = api.getProductsList()
        return response
    }

}
