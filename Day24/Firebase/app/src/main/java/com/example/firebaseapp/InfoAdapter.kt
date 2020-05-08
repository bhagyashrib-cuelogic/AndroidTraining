package com.example.firebaseapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.content.res.ColorStateListInflaterCompat.inflate

class InfoAdapter(private val contex: Context, private val layoutResId:Int, private val infoList:List<Info>) : ArrayAdapter<Info>(contex,layoutResId,infoList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
      val layoutInflater = LayoutInflater.from(context)
        val view :View = layoutInflater.inflate(layoutResId,null)

        val textViewFname:TextView? = view.findViewById<TextView>(R.id.firstname)
        val textViewLname:TextView? = view.findViewById<TextView>(R.id.lastname)

        val info = infoList[position]
            textViewFname?.text=info.FirstName
            textViewLname?.text = info.LastName
        return view
    }
}