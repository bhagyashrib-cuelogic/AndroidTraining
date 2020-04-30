package com.example.sqlite

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.content.Intent
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_data_show.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
//        var fullName = findViewById<EditText>(R.id.text_fname)
//        var password = findViewById<EditText>(R.id.text_password)
//        var phone = findViewById<EditText>(R.id.text_phone)
//        var country = findViewById<EditText>(R.id.text_country)
//        var submit = findViewById<Button>(R.id.button_submit)
                var context = this
             var db = OpenHelper(context)
             fun addData(view: View) {

                 val name = text_fname.text.toString()
                 val pass = text_password.text.toString()
                 val country = text_country.text.toString()
                 val databaseHandler: OpenHelper= OpenHelper(this)
                 if(name.isNotEmpty() && pass.isNotEmpty() && country.isNotEmpty()){
                  //   val status = databaseHandler.insertData(DataClass(name,pass,country))
                     var data = DataClass(name,pass,country)

                     var status = db.insertData(data)
                     if(status > -1){
                         Toast.makeText(applicationContext,"record save",Toast.LENGTH_LONG).show()
                       text_fname.text.clear()
                           text_password.text.clear()
                         text_phone.text.clear()
                         text_country.text.clear()
                     }
                 }else{
                     Toast.makeText(applicationContext,"please insert all data ",Toast.LENGTH_LONG).show()
                 }

             }

        fun showData(view: View) {
            var intent = Intent(this, DataShowActivity::class.java)
            startActivity(intent)
            setContentView(R.layout.activity_data_show)
            var data = db.showData()
            text_perosnName.text = ""
            person_password.text = ""
            person_country.text = ""
            if (data.size < 0)
                Toast.makeText(this, " record is not Found", Toast.LENGTH_LONG).show()
            else {
                for (i in 0..(data.size - 1)) {
                    text_perosnName.append(data[i].fullName)
                    person_password.append(data[i].passWord)
                    person_country.append(data[i].countryName)
                }
            }
        }

    fun deleteData(view: View){
         db.deleteData()
    }
}
