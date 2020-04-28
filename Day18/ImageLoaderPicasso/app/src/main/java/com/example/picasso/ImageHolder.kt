package com.example.picasso

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ImageHolder  : RecyclerView.Adapter<ImageAdapter>() {
   private val imageUrls : Array<String> = arrayOf("https://i.imgur.com/kUCMPWX.jpg","https://moodle.htwchur.ch/pluginfile.php/124614/mod_page/content/4/example.jpg","http://en.wikipedia.org/wiki/File:Ada_lovelace.jpg")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ImageAdapter {
        var imageItem = LayoutInflater.from(parent?.context).inflate(R.layout.item_image,parent,false)
        return ImageAdapter(imageItem)

    }

    override fun getItemCount(): Int {
        return imageUrls.size;

    }

    override fun onBindViewHolder(holder: ImageAdapter, position: Int) {
        var imageUrl = imageUrls[position]
        holder?.updateWithUrl(imageUrl)

    }


}