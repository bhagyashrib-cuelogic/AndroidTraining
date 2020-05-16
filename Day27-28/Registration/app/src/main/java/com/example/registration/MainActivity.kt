package com.example.registration

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Hello,${exit_fname.text.toString()} ${exit_lname.text.toString()}", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        button.setOnClickListener{
            message.text="Hello,${exit_fname.text.toString()} ${exit_lname.text.toString()}"
        }
    }


}
