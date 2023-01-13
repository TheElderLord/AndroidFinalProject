package com.example.finalproject

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.adapter.ProductAdapter
import com.example.finalproject.model.Product
import com.example.finalproject.retrofit.RetrofitClass
import com.example.finalproject.retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var itemList: ArrayList<Product>
    private lateinit var itemAdapter: ProductAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View = inflater.inflate(R.layout.fragment_home, container, false);



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val  context:Context = view.context
        recyclerView = view.findViewById(R.id.recyclerView)
        itemList = ArrayList()
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =llm
//        itemList.add(Product("Cola","Drinking poison","450"))
       //initialize adapter
        itemAdapter = ProductAdapter(context,itemList)
        recyclerView.adapter=itemAdapter
          fetchData()
        itemAdapter.onItemClick = {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("item",it)
            startActivity(intent)
        }
    }
    //fetchData from API
    private fun fetchData() {
        val retro = RetrofitClass.getRetrofit().create(RetrofitInterface::class.java)
        retro.getProducts().enqueue(object: Callback<List<Product>>{
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                for (item in response.body()!!) {
                    println(item)
                      itemList.add(Product(item.title,item.description,item.price,item.image))
                }
                itemAdapter.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.e("retrofit","Error occured")
            }
        })


    }




}
