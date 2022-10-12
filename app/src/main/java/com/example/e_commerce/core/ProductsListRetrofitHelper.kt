package com.example.e_commerce.core

import com.example.e_commerce.core.AppConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ProductsListRetrofitHelper {
    fun getRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl(AppConstants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }
}