package com.example.broadcastreciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.widget.Toast

class WifiConnection () : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (context != null) {
            if(Settings.System.getInt(context.contentResolver,Settings.Global.AIRPLANE_MODE_ON,0)==0){
                Toast.makeText(context,"Airloplane mode is on",Toast.LENGTH_LONG).show()

            }else
                Toast.makeText(context,"Airloplane mode is of",Toast.LENGTH_LONG).show()
        }

    }
    }