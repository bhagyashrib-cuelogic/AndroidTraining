package com.example.boundservice

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.text.SimpleDateFormat
import java.util.*

class ServiceBound : Service() {

    private val myBinder = MyLocalBinder()

    override fun onBind(intent: Intent): IBinder? {
        return myBinder
    }

    fun getCurrentTime(): String {
        val dateformat = SimpleDateFormat("HH:mm:ss MM/dd/yyyy",
            Locale.US)
        return dateformat.format(Date())
    }

    inner class MyLocalBinder : Binder() {
        fun getService(): ServiceBound {
            return this@ServiceBound
        }

    }
}