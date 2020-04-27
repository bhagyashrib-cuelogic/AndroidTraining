package com.example.intentservice

import android.app.IntentService
import android.content.Intent
import android.util.Log
import android.widget.Toast





class ServiceIntent : IntentService("ServiceIntent") {


   override fun onHandleIntent(intent: Intent?) {

       for (i in 1..5)
       {
           Toast.makeText(this,"value of I is $i",Toast.LENGTH_LONG).show()
           Log.d("Intent Service","Service is start $i")
           Thread.sleep(1000)
       }

    }

    override fun onStartCommand(intent: Intent?, flag: Int, startId: Int): Int {
        return super.onStartCommand(intent, flag, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
    }


}