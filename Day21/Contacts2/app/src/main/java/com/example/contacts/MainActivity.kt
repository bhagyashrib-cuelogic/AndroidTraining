package com.example.contacts

import android.app.AlertDialog
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    private val TAG = "PermissionDemo"
    private val RECORD_REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupPermissions()

        var data = contentResolver.query(
            ContentProviderDatabase.Content_URI,
            arrayOf(
                ContentProviderDatabase.FIRST_NAME,
                ContentProviderDatabase.LAST_NAME,
                ContentProviderDatabase.PHONE
            ),
            null, null, ContentProviderDatabase.FIRST_NAME
        )

        button_save.setOnClickListener {
            if (edit_firstName.text.isNotEmpty() && edit_lastName.text.isNotEmpty() && edit_phone.text.isNotEmpty()) {
                var cv = ContentValues()
                cv.put(ContentProviderDatabase.FIRST_NAME, edit_firstName.text.toString())
                cv.put(ContentProviderDatabase.LAST_NAME, edit_lastName.text.toString())
                cv.put(ContentProviderDatabase.PHONE, edit_phone.text.toString())
                contentResolver.insert(ContentProviderDatabase.Content_URI, cv)
                Toast.makeText(this, "Added ${cv.size()}", Toast.LENGTH_LONG).show()
                edit_phone.text.clear()
                edit_lastName.text.clear()
                edit_firstName.text.clear()
                if (data?.moveToNext()!!) {
                    Toast.makeText(this, "data", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "not Added ", Toast.LENGTH_LONG).show()
            }
        }

        button_show.setOnClickListener {
            if (data?.moveToNext()!!) {
                edit_firstName.setText(data.getString(0))
                edit_phone.setText(data.getString(2))
                edit_lastName.setText(data.getString(1))
            }
        }
    }

    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.WRITE_CONTACTS
        )

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permission denied")
            Log.i(TAG, "Permission to record denied")
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.WRITE_CONTACTS)) {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("Permission to access the microphone is required for this app to record audio.")
                        .setTitle("Permission required")
                            builder.setPositiveButton("OK"
                            ) { dialog, id ->
                        Log.i(TAG, "Clicked")
                        makeRequest()
                    }
                    val dialog = builder.create()
                dialog.show()
            } else {
                makeRequest()
            }
        }
    }
    private fun makeRequest() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.WRITE_CONTACTS),
            RECORD_REQUEST_CODE
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            RECORD_REQUEST_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Log.i(TAG, "Permission has been denied by user")
                } else {
                    Log.i(TAG, "Permission has been granted by user")
                }
            }
        }
    }
}


    /*----------------------------SQLOte code ----------------------------------*/
  /* private val context = this
    val db : OpenHelper = OpenHelper(context)

     fun addContacts(view:View)  {
         val firstName = edit_firstName.text.toString()
         val lastName = edit_lastName.text.toString()
         val contactNumber = edit_phone.text.toString()

         if (firstName.isNotEmpty() && lastName.isNotEmpty() && contactNumber.isNotEmpty()) {
             val adpater = ContactAdapter(firstName,contactNumber,lastName)
             val data = db.addContacts(adpater)
             Log.d("data value ","data after is $data")
              if(data > -1) {
                  Log.d("data value ","data is $data")
                  Toast.makeText(context, "Contact saved successfully", Toast.LENGTH_LONG).show()
                  edit_firstName.text.clear()
                  edit_lastName.text.clear()
                  edit_phone.text.clear()
              }
         }
         else {
             Toast.makeText(context, "Please insert Details", Toast.LENGTH_LONG).show()
         }
     }

    fun viewContacts(view: View){
        val intent:Intent = Intent(context,ContactList::class.java)
        startActivity(intent)
    } --------------------------------------------------------------*/

