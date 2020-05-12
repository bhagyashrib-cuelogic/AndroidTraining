package com.example.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Emp_Entity {

    @PrimaryKey
    var Emp_Id : Int = 0

    @ColumnInfo (name = "EmpName")
    var Emp_Name : String = ""

    @ColumnInfo (name = "EmpPost")
    var Emp_Post :String = ""

}