package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_start : Button = findViewById(R.id.btn_start)
        val tv_name : TextView = findViewById(R.id.tv_name)
        val user_name = tv_name.text

        btn_start.setOnClickListener{
            if (user_name.isNotEmpty()){
                val intent : Intent = Intent(this,QuestionsActivity::class.java)
                startActivity(intent)

            }else{
                Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}