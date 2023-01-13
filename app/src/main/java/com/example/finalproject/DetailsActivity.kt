package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.example.finalproject.model.Product

class DetailsActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var imageView: ImageView
    private lateinit var desc: TextView
    private lateinit var price: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val item = intent.getParcelableExtra<Product>("item")
        if (item!=null){
            imageView = findViewById(R.id.dimage)
            desc = findViewById(R.id.descipt)
            price=findViewById(R.id.price)
            textView=findViewById(R.id.dname)
            imageView.load(item.image)
            textView.text = item.title
            desc.text = item.description
            price.text = item.price

        }
    }
}