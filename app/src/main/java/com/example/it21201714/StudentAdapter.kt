package com.example.it21201714

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.it21201714.database.Student
import com.example.it21201714.database.StudentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudentAdapter(items:List<Student>, repository: StudentRepository, viewModel: MainActivityData): Adapter<StudentViewHolder>() {
    var context:Context? = null
    val items = items
    val repository = repository
    val viewModel = viewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item,parent,false)

        context=parent.context

        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.cbStudent.text = items.get(position).item
        holder.tvText.text =items.get(position).item2
        holder.tvAge.text=items.get(position).item3
        holder.ivDelete.setOnClickListener{
            val isChecked = holder.cbStudent.isChecked
            if(isChecked){
                CoroutineScope(Dispatchers.IO).launch {
                    repository.delete(items.get(position))
                    val data = repository.getAllStudentItems()
                    withContext(Dispatchers.Main){
                        viewModel.setData(data)
                    }
                }
                Toast.makeText(context,"Item Deleted",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(context,"Select the Item to be Deleted",Toast.LENGTH_LONG).show()
            }
        }
    }

}