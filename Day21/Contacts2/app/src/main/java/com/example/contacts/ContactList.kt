package com.example.contacts

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class ContactList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)


        val db = OpenHelper(this)
        var fname: ArrayList<String> = ArrayList()
        var lname: ArrayList<String> = ArrayList()
        var contact: ArrayList<String> = ArrayList()
        var lv: ListView = findViewById<ListView>(R.id.list_show)

        var db1 = db.readableDatabase;
        var dbc: SQLiteDatabase

        var cursor: Cursor = db1.rawQuery("SELECT * FROM  CONTACTS", null)
        if (cursor != null && cursor.count > 0) {
            if (cursor.moveToFirst()) {
                do {
                    fname.add(cursor.getString(cursor.getColumnIndex("FirstName")));
                    lname.add(cursor.getString(cursor.getColumnIndex("LastName")));
                    contact.add(cursor.getString(cursor.getColumnIndex("PhoneNumber")));
                } while (cursor.moveToNext());
            }
            val ca = listAdapter(this@ContactList, fname, lname, contact)
            lv.setAdapter(ca)
            cursor.close();
        } else {
                var intent : Intent = Intent(this,MainActivity::class.java)
                   startActivity(intent)
            Toast.makeText(this,"No record found",Toast.LENGTH_LONG).show()
        }
    }
}
