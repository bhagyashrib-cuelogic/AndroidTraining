package com.example.broadcastreciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast
import androidx.core.view.accessibility.AccessibilityEventCompat.getAction

class BroadClassReciverExample() : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent != null) {
            if (Intent.ACTION_BOOT_COMPLETED.equals(intent.action)) {
                Toast.makeText(context, "BOOT is completed", Toast.LENGTH_LONG).show()
            }
        }


        if (intent != null) {
            if(ConnectivityManager.CONNECTIVITY_ACTION == intent.action) {
                Toast.makeText(context, "Connectivity is changed", Toast.LENGTH_LONG).show()
            }
        }
    }
}