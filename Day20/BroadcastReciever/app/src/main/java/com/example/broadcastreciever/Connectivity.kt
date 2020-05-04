package com.example.broadcastreciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class Connectivity() : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent != null) {
            if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
                var conn : Boolean = intent.getBooleanExtra(
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY,false
                )
                 if(conn){
                     Toast.makeText(context,"Disconnected",Toast.LENGTH_LONG).show()
                 }
                else
                      Toast.makeText(context,"connected",Toast.LENGTH_LONG).show()
            }


        }
    }
}