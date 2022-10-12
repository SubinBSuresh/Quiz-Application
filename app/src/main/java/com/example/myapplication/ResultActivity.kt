package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val tvName: TextView = findViewById(R.id.tv_userName)
        val btnSubmit: Button = findViewById(R.id.btn_finish)
        val tvScore: TextView = findViewById(R.id.tv_score)

        val userName = intent.getStringExtra(Constants.USER_NAME)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        val totalQuestion = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)

        tvName.text = userName
        tvScore.text = "You scored "+correctAnswers +" out of " + totalQuestion

        btnSubmit.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}