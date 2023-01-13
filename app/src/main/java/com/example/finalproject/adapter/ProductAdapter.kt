package com.example.finalproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.finalproject.R
import com.example.finalproject.model.Product


//Adapter bridge between list and recyclerview
class ProductAdapter(private val context:Context, private val productList: ArrayList<Product>):RecyclerView.Adapter<ProductAdapter.ItemViewHolder>() {

    var onItemClick:((Product)->Unit)?=null
    class ItemViewHolder(itemview:View) : RecyclerView.ViewHolder(itemview){
        val itemImage:ImageView = itemview.findViewById(R.id.productImage)
        val itemTitle: TextView = itemview.findViewById(R.id.productTitle)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.product,parent,false )
        return ItemViewHolder(view)
    }

    //here happens binding
    //specific data for appropriate place
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val product =  productList[position]
        holder.itemTitle.text = product.title
        println(product.image)
        holder.itemImage.load(product.image)
//		Glide.with(context).load(product).into(holder.itemImage)

        holder.itemView.setOnClickListener{
          onItemClick?.invoke(product)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}
