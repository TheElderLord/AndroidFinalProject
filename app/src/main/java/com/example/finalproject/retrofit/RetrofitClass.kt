package com.example.finalproject.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClass {
    companion object{
        //setting url
        val url = "https://fakestoreapi.com/"
//retrofit converter
         fun getRetrofit():Retrofit{
            return Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}