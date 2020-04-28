package com.example.picasso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     val myImageView: ImageView = findViewById<ImageView>(R.id.imageView)

        Picasso.get().load("https://i.imgur.com/H981AN7.jpg").into(myImageView)
    }
}
