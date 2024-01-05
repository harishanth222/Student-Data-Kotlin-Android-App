package com.example.it21201714

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.it21201714.database.Student

class MainActivityData:ViewModel() {

    private val _data = MutableLiveData<List<Student>>()

    val data:LiveData<List<Student>> = _data

    fun setData(data:List<Student>){
        _data.value = data
    }
}