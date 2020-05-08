package com.example.gallery

import android.content.Context
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import java.io.File


class MainActivity : AppCompatActivity() {

    lateinit var gridView:GridView
    lateinit var list : ArrayList<File>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridView = findViewById<GridView>(R.id.image_grid)
        list = ImageReader(Environment.getExternalStorageDirectory())
    }

    class gridAdapter(var contex: Context,var list:ArrayList<File>):BaseAdapter(){
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var convertView :View?=null

            if(convertView==null){
                var inflater = this.getLayoutInflater(Context.LAYOUT_INFLATER_SERVICE)
            }

        }

        override fun getItem(position: Int): Any {
             return list[position]
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getCount(): Int {
            return list.size
        }


    }


    private fun ImageReader(externalStorageDirectory: File?): ArrayList<File> {
              var b : ArrayList<File> = ArrayList()
              var files : Array<File>? = externalStorageDirectory?.listFiles()

             for(i in 0..files?.size!!){
                 if(files[i].isDirectory) {
                     b.addAll(ImageReader(files[i]))
                 }
                 else{
                     if(files[i].name.endsWith(".jpg"))
                         b.add(files[i])
                 }
        }
        return b
    }
}
