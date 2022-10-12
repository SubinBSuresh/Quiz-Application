package com.example.myapplication

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val question1 = Question(
            1,"Which animal is this?",
            R.drawable.ic_launcher_foreground,
            "Dog","Cat", "Panda", "Rabbit",
            1
        )

        val question2 = Question(
            1,"Which animal is this?",
            R.drawable.ic_launcher_foreground,
            "Dog","Cat", "Panda", "Rabbit",
            3
        )

        val question3 = Question(
            1,"Which animal is this?",
            R.drawable.ic_launcher_foreground,
            "Dog","Cat", "Panda", "Rabbit",
            4
        )

        val question4 = Question(
            1,"Which animal is this?",
            R.drawable.ic_launcher_foreground,
            "Dog","Cat", "Panda", "Rabbit",
            2
        )

        val question5 = Question(
            1,"Which animal is this?",
            R.drawable.ic_launcher_foreground,
            "Dog","Cat", "Panda", "Rabbit",
            2
        )

        questionList.add(question1)
        questionList.add(question2)
        questionList.add(question3)
        questionList.add(question4)
        questionList.add(question5)
        return questionList
    }
}