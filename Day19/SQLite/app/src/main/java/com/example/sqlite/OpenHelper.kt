package com.example.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

private val DATABASE_VERSION = 1
private val DATABASE_NAME = "CollegeDatabase"
private val TABLE_NAME = "StudentTable"
private val STUD_NAME ="name"
private val STUD_PASSWORD = "password"
private val STUD_CONTACT = "phone"
private val STUD_COUNTRY = "country"



class OpenHelper( context: Context) : SQLiteOpenHelper(context,DATABASE_NAME,null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_STUDENT_TABLE = ("CREATE TABLE " + TABLE_NAME + "("
                +  STUD_NAME + " TEXT," + STUD_PASSWORD + " TEXT,"
                + STUD_CONTACT + "INTEGER PRIMARY KEY," + STUD_COUNTRY + " TEXT" + ")")
            db?.execSQL(CREATE_STUDENT_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

     fun insertData(dataClass: DataClass):Long {
         var db = this.writableDatabase
         var dataAdd = ContentValues()
         dataAdd.put(STUD_NAME, dataClass.fullName)
         dataAdd.put(STUD_PASSWORD, dataClass.passWord)
         dataAdd.put(STUD_COUNTRY, dataClass.countryName)
        var success =  db.insert(TABLE_NAME,null, dataAdd)
         db.close()
         return success
     }

    fun showData():MutableList<DataClass>{
     var list :MutableList<DataClass> = ArrayList()
        var db = this.readableDatabase
        var query = "SELECT * FROM $TABLE_NAME"
        var result = db.rawQuery(query,null)
        result.moveToFirst()
        do{
            var data = DataClass()
            data.fullName = result.getString(result.getColumnIndex(STUD_NAME)).toString()
            data.passWord = result.getString(result.getColumnIndex(STUD_PASSWORD)).toString()
            data.countryName= result.getString(result.getColumnIndex(STUD_COUNTRY)).toString()
            list.add(data)
        }while (result.moveToNext())
        result.close()
        db.close()
        return list
    }

    fun deleteData()
    {
        val db = this.writableDatabase
       // db.delete(TABLE_NAME, "$STUD_NAME=?", arrayOf(1.toString()))
        db.delete(TABLE_NAME, null,null)
    }
}