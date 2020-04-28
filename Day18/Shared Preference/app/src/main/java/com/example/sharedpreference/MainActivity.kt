package com.example.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    val MyPREFERENCES = "MyPrefs"
    val Name = "nameKey"
    val Phone = "phoneKey"
    val Email = "emailKey"

   // var sharedPreferences: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ed1 = findViewById<EditText>(R.id.editText)
        var ed2 = findViewById<EditText>(R.id.editText2)
        var ed3 = findViewById<EditText>(R.id.editText3)
        var b1 = findViewById<Button>(R.id.button_save)

        var name = findViewById<TextView>(R.id.textViewShowName)
        var pass = findViewById<TextView>(R.id.textViewShowPass)
        var email = findViewById<TextView>(R.id.textViewShowEmail)

      var  sharedPreferences:SharedPreferences = this.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE)

        b1.setOnClickListener(View.OnClickListener {

            val n = ed1.text.toString()
            val ph = ed2.text.toString()
            val e = ed3.text.toString()
            val editor:SharedPreferences.Editor =  sharedPreferences.edit()

            editor.putString(Name, n)
            editor.putString(Phone, ph)
            editor.putString(Email, e)
            editor.apply()
            editor.commit()
            Toast.makeText(this@MainActivity, "Add Successfully", Toast.LENGTH_LONG).show()

        })

       button_show.setOnClickListener {
          val sharedName = sharedPreferences.getString("Name","DefaultName")
          val sharedPass = sharedPreferences.getString("Phone","DefaultPhone")
           val sharedEmail= sharedPreferences.getString("Email","DefaultEmail")
           if(sharedName.equals("DefaultName") && sharedPass.equals("DefaultPhone") && sharedEmail.equals("DefaultEmail")){
               name.setText("default name: ${sharedName}").toString()
               pass.text = "default Pass: ${sharedPass.toString()}"
               email.text = "default id: ${sharedEmail.toString()}"

       }else{

               name.setText(sharedName).toString()
               pass.setText(sharedPass).toString()
               email.setText(sharedEmail).toString()
       }
   }
   }
}
