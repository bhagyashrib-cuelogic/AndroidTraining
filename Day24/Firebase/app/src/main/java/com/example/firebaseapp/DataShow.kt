package com.example.firebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ListView
import com.google.firebase.database.*

class DataShow : AppCompatActivity() {

   private lateinit var dataReference :DatabaseReference
    private lateinit var userList : MutableList<Info>
    private lateinit var listView :ListView
    private lateinit var listShow : LayoutInflater
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_show)
         dataReference = FirebaseDatabase.getInstance().getReference("UserInfo")

        userList = mutableListOf()
        listView = findViewById(R.id.dataShow)

        dataReference.addValueEventListener(object: ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0!!.exists())
                {
                    for( i in p0.children) {
                        var infoUser = i.getValue(Info::class.java)
                        userList.add(infoUser!!)
                    }
                    val adpater = InfoAdapter(applicationContext,R.layout.listshow,userList)
                    listView.adapter = adpater
                }
            }
        })
    }
}
