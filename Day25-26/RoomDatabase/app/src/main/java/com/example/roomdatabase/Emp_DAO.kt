package com.example.roomdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Emp_DAO {

    @Insert
    fun saveEnp(emp : Emp_Entity)

    @Query ("select * from Emp_Entity")
    fun readEmp():List<Emp_Entity>
}