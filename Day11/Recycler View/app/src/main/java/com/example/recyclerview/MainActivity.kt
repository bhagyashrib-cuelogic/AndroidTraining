package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item.*

class MainActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>? = null
    val users = ArrayList<User>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val textview_Name = findViewById<TextView>(R.id.text_Name)


        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager =layoutManager


        //recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)

      // button_Add.setOnClickListener {

           // users.add(User(textPersonAdd,textPersonName))
            users.add(User("Bhagya","Katraj"))
            users.add(User("Pooja","Kolhypaur"))
            users.add(User("Sakshi","satara"))
            users.add(User("Dipak","Nagar"))
            users.add(User("Ahmad","Karachi"))
            users.add(User("divya","mumbai"))
            users.add(User("Vijay","Shirwal"))
            users.add(User("Aksh","Bhor"))
            users.add(User("Abhi","Sangli"))
            users.add(User("Mayur","Jaypur"))
            users.add(User("Stuti","Delhi"))
            users.add(User("Kalyani","Pune"))

            recyclerView.adapter = CustomeAdapter(users)


    }
}
