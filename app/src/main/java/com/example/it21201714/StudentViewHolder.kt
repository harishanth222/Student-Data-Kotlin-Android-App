package com.example.it21201714

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class StudentViewHolder(view:View):ViewHolder(view) {
    val cbStudent:CheckBox = view.findViewById(R.id.cbStudent)
    val ivDelete:ImageView = view.findViewById(R.id.ivDelete)
    val tvText:TextView= view.findViewById(R.id.textView2)
    val tvAge:TextView= view.findViewById(R.id.textView5)


}