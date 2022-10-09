package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

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
    private var mQuestionList: List<Question>? = null
    private var mSelectedOption: Int = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        tvOption1 = findViewById(R.id.tv_option1)
        tvOption2 = findViewById(R.id.tv_option2)
        tvOption3 = findViewById(R.id.tv_option3)
        tvOption4 = findViewById(R.id.tv_option4)
        btnSubmit = findViewById(R.id.btn_submit)
        ivImage = findViewById(R.id.iv_questionImage)

        tvOption1?.setOnClickListener(this)
        tvOption2?.setOnClickListener(this)
        tvOption3?.setOnClickListener(this)
        tvOption4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionList = Constants.getQuestions()
        setQuestion()
        defaultOptionsView()
    }

    private fun setQuestion() {
        val question: Question = mQuestionList!![currentPosition - 1]
        progressBar?.progress = currentPosition
        tvProgress?.text = "$currentPosition / ${progressBar?.max}"

        tvQuestion?.text = question.question
        tvOption1?.text = question.option1
        tvOption2?.text = question.option2
        tvOption3?.text = question.option3
        tvOption4?.text = question.option4
        ivImage?.setImageResource(question.image)

        if (currentPosition == mQuestionList!!.size) {
            btnSubmit?.text = "Finish"
        } else {
            btnSubmit?.text = "Submit"
        }
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        tvOption1?.let {
            options.add(0, it)
        }
        tvOption2?.let {
            options.add(1, it)
        }
        tvOption3?.let {
            options.add(2, it)
        }
        tvOption4?.let {
            options.add(3, it)
        }
        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int) {
        defaultOptionsView()
        mSelectedOption = selectedOptionNumber
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.default_options_border
        )
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                tvOption1?.background = ContextCompat.getDrawable(this,drawableView)
            }
            2 -> {
                tvOption2?.background = ContextCompat.getDrawable(this,drawableView)
            }
            3 -> {
                tvOption3?.background = ContextCompat.getDrawable(this,drawableView)
            }
            4 -> {
                tvOption4?.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_option1 -> {
                tvOption1?.let {
                    selectedOptionView(it, 1)
                }
            }
            R.id.tv_option2 -> {
                tvOption2?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.tv_option3 -> {
                tvOption3?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.tv_option4 -> {
                tvOption4?.let {
                    selectedOptionView(it, 4)
                }
            }
            R.id.btn_submit -> {
                if (mSelectedOption == 0){
                    currentPosition++
                    when{
                        currentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                    }
                } else{
                    val question = mQuestionList?.get(currentPosition -1)
                    if (question!!.correctOption != mSelectedOption){
                        answerView(mSelectedOption, R.drawable.wrong_option_border_bg)
                    }
                    answerView(question.correctOption, R.drawable.correct_option_border_bg)

                    if (currentPosition == mQuestionList!!.size){

                    }
                }

            }
        }
    }
}