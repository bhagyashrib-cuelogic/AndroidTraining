package com.example.boundservice

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    var myService: ServiceBound? = null
    var isBound = false
    //var myTextView : String ? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this, ServiceBound::class.java)
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE)
    }

    fun showTime(view: View) {
        val currentTime = myService?.getCurrentTime()
            textView.text=currentTime
    }

    private val myConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName,
                                        service: IBinder) {
            val binder = service as ServiceBound.MyLocalBinder
            myService = binder.getService()
            isBound = true
        }

        override fun onServiceDisconnected(name: ComponentName) {
            isBound = false
        }
    }
}
