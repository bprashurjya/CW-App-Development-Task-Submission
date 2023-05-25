package com.example.triviaapp


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.triviaapp.R




class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var questionTextView: TextView
    private lateinit var option1Button: Button
    private lateinit var option2Button: Button
    private lateinit var option3Button: Button
    private lateinit var option4Button: Button

    private val questions = arrayOf(
        "What is the capital of France?",
        "Who painted the Mona Lisa?",
        "What is the tallest mountain in the world?"
    )

    private val options = arrayOf(
        arrayOf("Paris", "London", "Berlin", "Madrid"),
        arrayOf( "Pablo Picasso", "Vincent van Gogh","Leonardo da Vinci", "Michelangelo"),
        arrayOf( "K2", "Kangchenjunga", "Makalu", "Mount Everest")
    )

    private val correctAnswers = intArrayOf(0, 2, 3) // Indices of the correct options for each question
    private var currentQuestionIndex = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionTextView = findViewById(R.id.questionTextView)
        option1Button = findViewById(R.id.option1Button)
        option2Button = findViewById(R.id.option2Button)
        option3Button = findViewById(R.id.option3Button)
        option4Button = findViewById(R.id.option4Button)

        option1Button.setOnClickListener(this)
        option2Button.setOnClickListener(this)
        option3Button.setOnClickListener(this)
        option4Button.setOnClickListener(this)

        showQuestion()
    }

    override fun onClick(view : View) {
        val selectedOption = when (view .id) {
            R.id.option1Button -> 0
            R.id.option2Button -> 1
            R.id.option3Button -> 2
            R.id.option4Button -> 3
            else -> -1
        }

        checkAnswer(selectedOption)
    }

    private fun showQuestion() {
        questionTextView.text = questions[currentQuestionIndex]
        option1Button.text = options[currentQuestionIndex][0]
        option2Button.text = options[currentQuestionIndex][1]
        option3Button.text = options[currentQuestionIndex][2]
        option4Button.text = options[currentQuestionIndex][3]
    }

    private fun checkAnswer(selectedOption: Int) {
        if (selectedOption == correctAnswers[currentQuestionIndex]) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
        }

        currentQuestionIndex++

        if (currentQuestionIndex < questions.size) {
            showQuestion()
        } else {
            Toast.makeText(this, "Quiz completed!", Toast.LENGTH_SHORT).show()
        }
    }
}
