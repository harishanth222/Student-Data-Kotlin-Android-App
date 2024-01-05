package com.example.it21201714

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {

    val detailFragment = DetailFragment()
    val moduleFragment = ModuleFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val detailBtn: Button = findViewById(R.id.btnDetail)
        val proBtn: Button = findViewById(R.id.btnPro)

        detailBtn.setOnClickListener {
            loadDetail()
        }

        proBtn.setOnClickListener {
            loadModule()
        }
    }

    private fun loadDetail() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if(fragment==null){
            supportFragmentManager.beginTransaction().add(R.id.fragment_container,detailFragment).commit()
        }else{
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,detailFragment).commit()
        }
    }

    private fun loadModule() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if(fragment==null){
            supportFragmentManager.beginTransaction().add(R.id.fragment_container,moduleFragment).commit()
        }else{
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,moduleFragment).commit()
        }
    }
}




