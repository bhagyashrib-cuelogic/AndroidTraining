package com.example.filehandling

import android.R.attr.path
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*
import java.io.FileOutputStream


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.edit_name)
        val email = findViewById<EditText>(R.id.edit_email)
        val save = findViewById<Button>(R.id.button_save)

        save.setOnClickListener(View.OnClickListener {
            val file:String = name.text.toString()
            val data:String = email.text.toString()
            val fileOutputStream:FileOutputStream
            try {
                fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
                fileOutputStream.write(data.toByteArray())
                Toast.makeText(this,"Add data into file successfully",Toast.LENGTH_LONG).show()
                name.text.clear()
                email.text.clear()
            }catch (e: Exception){
                e.printStackTrace()
            }

        })

       button_show.setOnClickListener(View.OnClickListener {
            val filename =name.text.toString()
            if(filename.toString()!=null && filename.toString().trim()!=""){
                var fileInputStream: FileInputStream? = null
                fileInputStream = openFileInput(filename)
                var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
                val stringBuilder: StringBuilder = StringBuilder()
                var text: String? = null
                while ({ text = bufferedReader.readLine(); text }() != null) {
                    stringBuilder.append(text)
                }
                //Displaying data on EditText
                email.setText(stringBuilder.toString()).toString()
            }else{
                Toast.makeText(applicationContext,"file name cannot be blank",Toast.LENGTH_LONG).show()
            }
        })

    }
}
