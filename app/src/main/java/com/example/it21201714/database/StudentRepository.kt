package com.example.it21201714.database

class StudentRepository(
    private val db:StudentDatabase
){

    suspend fun insert(todo:Student) = db.getStudentDao().insert(todo)
    suspend fun delete(todo:Student) = db.getStudentDao().delete(todo)
    fun getOne(id:String):Student = db.getStudentDao().getOne(id)
    fun getAllStudentItems():List<Student> = db.getStudentDao().getAllStudentItems()


}