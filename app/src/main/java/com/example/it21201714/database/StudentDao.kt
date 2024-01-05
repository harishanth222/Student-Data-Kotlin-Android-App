package com.example.it21201714.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {

    @Insert
    suspend fun insert(Student: Student)

    @Delete
    suspend fun delete(Student: Student)

    @Query("SELECT * FROM Student")
    fun getAllStudentItems():List<Student>

    @Query("SELECT * FROM Student WHERE item=:id")
    fun getOne(id:String):Student
}