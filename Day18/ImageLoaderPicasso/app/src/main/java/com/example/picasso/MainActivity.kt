package com.example.picasso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//     val myImageView: ImageView = findViewById<ImageView>(R.id.imageView)
//
//        Picasso.get().load("https://i.imgur.com/H981AN7.jpg").into(myImageView)


        imageRecyclerView.layoutManager = LinearLayoutManager(this)
        imageRecyclerView.adapter = ImageHolder()
    }

}
