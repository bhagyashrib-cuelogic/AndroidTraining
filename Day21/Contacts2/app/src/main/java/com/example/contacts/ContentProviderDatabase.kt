package com.example.contacts

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.net.Uri

class ContentProviderDatabase : ContentProvider() {

    companion object{
            val PROVIDER_NAME = "com.example.contacts/ ContentProviderDatabase"
            val URL = "content://$PROVIDER_NAME/CONTACTS"
            val Content_URI = Uri.parse(URL)
            val FIRST_NAME = "FirstName"
            val LAST_NAME = "LastName"
            val PHONE = "PhoneNumber"
    }
    lateinit var db : SQLiteDatabase
    override fun onCreate(): Boolean {
      var helper = OpenHelper(context)
      db = helper.writableDatabase
        return db!= null

    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        TODO("Not yet implemented")
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
           db.insert("CONTACTS",null,values)
        context?.contentResolver?.notifyChange(uri,null)
        return uri
    }

    override fun query(
        uri: Uri,
    cols: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
               return db.query("CONTACTS",cols,selection,selectionArgs,null,null,null)
    }
    
    override fun getType(uri: Uri): String? {
           return "vdn.android.cursor.dir/vnd.example.contacts"
    }
}