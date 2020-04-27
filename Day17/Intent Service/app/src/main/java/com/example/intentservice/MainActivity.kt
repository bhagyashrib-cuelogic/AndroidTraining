package com.example.intentservice

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    public fun startService(view : View){
        val intent = Intent(this, ServiceIntent::class.java)
        Toast.makeText(this,"Service is start ",Toast.LENGTH_LONG).show()
        startService(intent)
    }

    public fun stopService(view : View){
        val intent = Intent(this, ServiceIntent::class.java)
        Toast.makeText(this,"Service is stop ",Toast.LENGTH_LONG).show()
        stopService(intent)


    }
}
