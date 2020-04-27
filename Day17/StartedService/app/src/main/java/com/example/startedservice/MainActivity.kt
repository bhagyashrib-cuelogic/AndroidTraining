package com.example.startedservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.content.Intent
import android.util.Log

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun startService(view : View){
        intent = Intent(this,StaredService::class.java)
        startService(intent)
        Log.e("Start","Start activity")
    }

    fun stopService(view :View){

        intent = Intent(this,StaredService::class.java)
        stopService(intent)
        Log.e("Start","Stop activity")

    }

}
