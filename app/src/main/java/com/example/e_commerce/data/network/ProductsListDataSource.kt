package com.example.e_commerce.data.network
import com.example.e_commerce.core.AppConstants
import com.example.e_commerce.core.ProductsListRetrofitHelper
import com.example.e_commerce.data.model.ProductResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext



class ProductsListDataSource{

    private val retrofit = ProductsListRetrofitHelper.getRetrofit()
    suspend fun getProductsList(): ProductResponse {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(WebServiceProductList::class.java).getAllProductsList(AppConstants.API_KEY)
            response.body() ?: ProductResponse()
        }
    }
}