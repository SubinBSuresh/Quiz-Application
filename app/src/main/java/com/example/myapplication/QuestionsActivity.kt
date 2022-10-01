package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuestionsActivity : AppCompatActivity(), View.OnClickListener{

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var tvOption1: TextView? = null
    private var tvOption2: TextView? = null
    private var tvOption3: TextView? = null
    private var tvOption4: TextView? = null
    private var btnSubmit: Button? = null
    private var ivImage: ImageView? = null

    private var currentPosition: Int = 1
    private var mQuestionList:List<Question>?=null
    private var mSelectedOption: Int = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        mQuestionList = Constants.getQuestions()

        setQuestion()

    }

    private fun setQuestion() {
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        tvOption1 = findViewById(R.id.tv_option1)
        tvOption2 = findViewById(R.id.tv_option2)
        tvOption3 = findViewById(R.id.tv_option3)
        tvOption4 = findViewById(R.id.tv_option4)
        btnSubmit = findViewById(R.id.btn_submit)
        ivImage = findViewById(R.id.iv_questionImage)

        val question: Question = mQuestionList!![currentPosition - 1]
        progressBar?.progress = currentPosition
        tvProgress?.text = "$currentPosition / ${progressBar?.max}"

        tvQuestion?.text = question.question
        tvOption1?.text = question.option1
        tvOption2?.text = question.option2
        tvOption3?.text = question.option3
        tvOption4?.text = question.option4
        ivImage?.setImageResource(question.image)
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}