package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
// var id = findViewById<EditText>(R.id.edit_id)
//        var name= findViewById<EditText>(R.id.editText2)
//        var post = findViewById<EditText>(R.id.edit_post)
//
//        var idemp = id.toString().trim()
//        Log.d("Main","Value of idem is $idemp")
         var save = findViewById<Button>(R.id.button_save)

        var db = Room.databaseBuilder(applicationContext,AppDB::class.java,"Employee").build()
        var emp = Emp_Entity()
        save.setOnClickListener {
            Thread {
                var id = findViewById<EditText>(R.id.edit_id)
               emp.Emp_Id = edit_id.text.toString().toInt()
                emp.Emp_Name = edit_name.text.toString()
                emp.Emp_Post = edit_post.text.toString()
                db.empDAO().saveEnp(emp)

                db.empDAO().readEmp().forEach() {
                    Log.i("@Main", "Emp id is ${it.Emp_Id}")
                    Log.i("@Main", "Emp name is ${it.Emp_Name}")
                    Log.i("@Main", "Emp post is ${it.Emp_Post}")
                }
            }.start()
        }

        var id = findViewById<EditText>(R.id.edit_id)
        var name= findViewById<EditText>(R.id.edit_name)
        var post = findViewById<EditText>(R.id.edit_post)

        var idemp = id.toString().trim()
        Log.d("Main","Value of idem is $idemp")
    }
}
