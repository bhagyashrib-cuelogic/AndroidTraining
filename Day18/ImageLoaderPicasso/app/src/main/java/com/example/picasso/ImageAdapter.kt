package com.example.picasso

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso

class ImageAdapter (itemView : View): RecyclerView.ViewHolder(itemView) {

    private val myImageView: ImageView = itemView.findViewById<ImageView>(R.id.imageView)

    fun updateWithUrl(url: String) {
        Picasso.get().load(url).into(myImageView)
    }
}