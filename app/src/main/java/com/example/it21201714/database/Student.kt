package com.example.it21201714.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    var item:String?,
    var item2:String?,
    var item3:String?,
    var item4:String?,
    var item5:String?,
    var item6:String?,
    var item7:String?,
    var item8:String?
){
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null

}