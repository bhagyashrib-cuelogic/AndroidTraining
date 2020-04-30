package com.example.broadcastreciever

import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var conn = Connectivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
         var filter :IntentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(conn,filter)
        Toast.makeText(this,"App is start",Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(conn)
        Toast.makeText(this,"App is stop",Toast.LENGTH_LONG).show()
    }
}
