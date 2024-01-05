package com.example.it21201714

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.it21201714.database.Student
import com.example.it21201714.database.StudentDatabase
import com.example.it21201714.database.StudentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: StudentAdapter
    private lateinit var viewModel: MainActivityData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.rvStudentList)
        val repository = StudentRepository(StudentDatabase.getInstance(this))

        viewModel = ViewModelProvider(this)[MainActivityData::class.java]

        viewModel.data.observe(this) {
            adapter = StudentAdapter(it, repository, viewModel)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)
        }

        CoroutineScope(Dispatchers.IO).launch {
            val data = repository.getAllStudentItems()
            runOnUiThread {
                viewModel.setData(data)
            }
        }

        val addItem: Button = findViewById(R.id.btnAddItem)

        addItem.setOnClickListener {
            displayAlert(repository)
        }

        val btn:Button = findViewById(R.id.button)

        btn.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }

    private fun displayAlert(repository: StudentRepository) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getText(R.string.alertTitle))

        // Create a layout to hold both input fields
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        // Create a message TextView above the first input field
        val message1 = TextView(this)
        message1.setText(getString(R.string.stID))
        layout.addView(message1)

        // Create the first input field
        val input = EditText(this)
        input.inputType = InputType.TYPE_CLASS_TEXT
        layout.addView(input)

        // Create a message TextView above the second input field
        val message2 = TextView(this)
        message2.setText(getString(R.string.stdName))
        layout.addView(message2)

        // Create the second input field
        val input2 = EditText(this)
        input2.inputType = InputType.TYPE_CLASS_TEXT
        layout.addView(input2)

        val message3 = TextView(this)
        message3.setText(getString(R.string.stdAge))
        layout.addView(message3)

        // Create the second input field
        val input3 = EditText(this)
        input3.inputType = InputType.TYPE_CLASS_TEXT
        layout.addView(input3)

        val message4 = TextView(this)
        message4.setText(getString(R.string.Mo1))
        layout.addView(message4)

        // Create the second input field
        val input4 = EditText(this)
        input4.inputType = InputType.TYPE_CLASS_TEXT
        layout.addView(input4)

        val message5 = TextView(this)
        message5.setText(getString(R.string.Mo2))
        layout.addView(message5)

        // Create the second input field
        val input5 = EditText(this)
        input5.inputType = InputType.TYPE_CLASS_TEXT
        layout.addView(input5)

        val message6 = TextView(this)
        message6.setText(getString(R.string.Mo3))
        layout.addView(message6)

        // Create the second input field
        val input6 = EditText(this)
        input6.inputType = InputType.TYPE_CLASS_TEXT
        layout.addView(input6)

        val message7 = TextView(this)
        message7.setText(getString(R.string.Mo4))
        layout.addView(message7)

        // Create the second input field
        val input7 = EditText(this)
        input7.inputType = InputType.TYPE_CLASS_TEXT
        layout.addView(input7)

        val message8 = TextView(this)
        message8.setText(getString(R.string.Mo5))
        layout.addView(message8)

        // Create the second input field
        val input8 = EditText(this)
        input8.inputType = InputType.TYPE_CLASS_TEXT
        layout.addView(input8)


        builder.setView(layout)

        builder.setPositiveButton("OK") { dialog, which ->
            val item1 = input.text.toString()
            val item2 = input2.text.toString()
            val item3 = input3.text.toString()
            val item4 = input4.text.toString()
            val item5 = input5.text.toString()
            val item6 = input6.text.toString()
            val item7 = input7.text.toString()
            val item8 = input8.text.toString()



            // Insert both items into the database
            CoroutineScope(Dispatchers.IO).launch {
                repository.insert(Student(item1,item2,item3,item4,item5,item6,item7,item8))
                val data = repository.getAllStudentItems()
                runOnUiThread {
                    viewModel.setData(data)
                }
            }
        }

        builder.setNegativeButton("Cancel") { dialog, which ->
            dialog.cancel()
        }

        val alertDialog = builder.create()
        alertDialog.show()
    }
    }
