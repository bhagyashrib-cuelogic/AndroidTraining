package com.example.firebaseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var firstName: EditText
    private lateinit var lastName :EditText
    private lateinit var saveButton :Button
    private lateinit var showButton :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstName = findViewById(R.id.firstName)
        lastName = findViewById(R.id.lastname)
        saveButton = findViewById(R.id.button_save)
        showButton = findViewById(R.id.show_button)


        saveButton.setOnClickListener{
            saveInfo()
        }
        showButton.setOnClickListener{
            showData()
        }
    }

    private fun saveInfo(){
        val fName = firstName.text.toString().trim()
        val lName = lastName.text.toString().trim()

        if(fName.isEmpty() && lName.isEmpty()){
            firstName.error = "Please Enter first name"
            lastName.error = "Please Enter last name"
        }

        //Firebase instance
        val dataReference = FirebaseDatabase.getInstance().getReference("UserInfo")
        //created unique key
        val userId:String  = dataReference.push().key!!
     //   val info = Info(userId,fName,lName)
        dataReference.child(userId).setValue(Info(userId,fName,lName)).addOnCompleteListener{
            Toast.makeText(applicationContext,"Data added succsesfully into firebase",Toast.LENGTH_LONG).show()
        }
        lastName.text.clear()
        firstName.text.clear()
    }
    private fun showData()
    {
         val intent : Intent = Intent(this@MainActivity,DataShow::class.java)
        startActivity(intent)
    }
}
