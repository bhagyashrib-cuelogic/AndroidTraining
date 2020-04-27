package com.example.startedservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class StaredService : Service() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Toast.makeText(this,"Service stared..",Toast.LENGTH_LONG).show()
        return START_STICKY
    }

    
    override fun onDestroy() {

        Toast.makeText(this,"Destroy Servic..",Toast.LENGTH_LONG).show()
    }


    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}