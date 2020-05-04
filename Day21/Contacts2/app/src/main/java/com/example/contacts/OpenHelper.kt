package com.example.contacts

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class OpenHelper(var context: Context?) : SQLiteOpenHelper(context, DATABASE_NAME, null , 1) {

    companion object {
        private var DATABASE_NAME = "CONTACT LIST"
        private var TABLE_NAME = "CONTACTS"
        private var FIRST_NAME = "FirstName"
        private var LAST_NAME = "LastName"
        private var PHONE_NUMBER = "PhoneNumber"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val contactsTable =
            "CREATE TABLE $TABLE_NAME($PHONE_NUMBER INTEGER PRIMARY KEY,$FIRST_NAME TEXT,$LAST_NAME TEXT)"
        db?.execSQL(contactsTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun addContacts(contacts: ContactAdapter): Long {
        var add = ContentValues()
        var db = this.writableDatabase

        add.put(FIRST_NAME, contacts.firstName)
        add.put(LAST_NAME, contacts.lastName)
        add.put(PHONE_NUMBER, contacts.contactNumber)
        var result = db.insert(TABLE_NAME, null, add)
        if (result < -1) {
            Toast.makeText(context, "Not added", Toast.LENGTH_LONG).show()
        }
        return result
    }

}

