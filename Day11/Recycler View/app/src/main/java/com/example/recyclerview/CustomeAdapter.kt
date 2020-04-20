package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//import androidx.appcompat.app.AlertController

class CustomeAdapter(val  userList:ArrayList<User>) : RecyclerView.Adapter<CustomeAdapter.ViewHolder>()
{
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user :User = userList[position]

        holder?.textName?.text = user.name
        holder?.textAdd?.text = user.add

    }

    override fun getItemCount(): Int {
        return userList.size

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(v)

    }

    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)
    {
        val textName  = itemView.findViewById<TextView>(R.id.text_Name)
        val textAdd = itemView.findViewById<TextView>(R.id.text_Add)
    }

}