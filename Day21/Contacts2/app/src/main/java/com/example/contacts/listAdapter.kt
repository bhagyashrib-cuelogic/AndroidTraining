package com.example.contacts

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


class listAdapter(var context : Context,var fname:ArrayList<String>,var lname:ArrayList<String>,var contact:ArrayList<String>) : BaseAdapter (){
    private var mContext: Context? = null
    var controldb: OpenHelper? = null
    var db: SQLiteDatabase? = null

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        var holder: ViewHolder = ViewHolder()

        if (convertView == null) {
            holder = ViewHolder()

            var inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
             convertView = inflater.inflate(R.layout.contacts_list, null);
            holder.f_name = convertView.findViewById(R.id.text_fname) as TextView
            holder.l_name = convertView.findViewById(R.id.text_lname) as TextView
            holder.cont = convertView.findViewById(R.id.text_phone) as TextView
        }else{
            convertView.tag = holder
        }
        holder.f_name?.text = fname[position]
        holder.l_name?.text = lname[position]
        holder.cont?.text = contact[position]

        return convertView
    }
        override fun getItem(position: Int): Any? {
            return null;
        }

        override fun getItemId(position: Int): Long {
            return 0;
        }

        override fun getCount(): Int {
            return contact.size;
        }

        private inner class ViewHolder {

            var f_name : TextView? = null
            var l_name: TextView? = null
            var cont: TextView ?= null
        }
    }