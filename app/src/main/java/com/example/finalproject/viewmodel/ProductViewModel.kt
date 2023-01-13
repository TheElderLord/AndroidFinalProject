package com.example.finalproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.model.Product
import com.example.finalproject.retrofit.RetrofitClass
import com.example.finalproject.retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductViewModel: ViewModel() {
    lateinit var liveData: MutableLiveData<List<Product>>
    init {
        liveData = MutableLiveData()


    }
    @JvmName("getLiveData1")
    fun getLiveData():MutableLiveData<List<Product>>{
        return liveData
    }
    fun requestAPI(){
        val retrofit = RetrofitClass.getRetrofit()
        val retInterface =  retrofit.create(RetrofitInterface::class.java)
        val productList = retInterface.getProducts()
        productList.enqueue(object : Callback<List<Product>>{
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                liveData.postValue(null)
                 }

            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
               liveData.postValue(response.body())
            }
        })
    }


}