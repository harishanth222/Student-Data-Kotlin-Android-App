package com.example.it21201714

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.it21201714.database.StudentDatabase
import com.example.it21201714.database.StudentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ModuleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ModuleFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_module, container, false)

        val repository = StudentRepository(StudentDatabase.getInstance(requireActivity()))

        val edtID:EditText = rootView.findViewById(R.id.edtID)
        val btnModule:Button = rootView.findViewById(R.id.btnModule)

        btnModule.setOnClickListener {
            val studentId = edtID.text.toString()

            if (studentId.isNotEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    val student = withContext(Dispatchers.IO) {
                        repository.getOne(edtID.text.toString())
                    }
                    if(student!=null){
                        withContext(Dispatchers.Main){
                            val edtMf1: EditText = rootView.findViewById(R.id.edtMf1)
                            edtMf1.setText(student.item4)

                            val edtMf2: EditText = rootView.findViewById(R.id.edtMf2)
                            edtMf2.setText(student.item5)

                            val edtMf3: EditText = rootView.findViewById(R.id.edtMf3)
                            edtMf3.setText(student.item6)

                            val edtMf4: EditText = rootView.findViewById(R.id.edtMf4)
                            edtMf4.setText(student.item7)

                            val edtMf5: EditText = rootView.findViewById(R.id.edtMf5)
                            edtMf5.setText(student.item8)
                        }
                    }else{
                        withContext(Dispatchers.Main){
                            Toast.makeText(requireActivity(), "No record found", Toast.LENGTH_SHORT).show()
                        }
                    }

                }
            }else {
                Toast.makeText(requireActivity(), "Student ID can't be blank", Toast.LENGTH_SHORT).show()
            }



        }

        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ModuleFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ModuleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}