package com.example.finalproject.retrofit


import com.example.finalproject.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {
    //get the products from API
    @GET("products")
    fun getProducts(): Call<List<Product>>
}