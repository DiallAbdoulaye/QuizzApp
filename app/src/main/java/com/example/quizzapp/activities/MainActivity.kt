package com.example.quizzapp.activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quizzapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        val sharedPreferences = getSharedPreferences("com.example.quizzapp", Context.MODE_PRIVATE)
        val userScore = sharedPreferences.getInt("userScore", -1)

        if (userScore > -1) {
            textView.text = "Ton dernier score est de $userScore"
        }
    }

    fun onClickBtnPlay(view:View) {
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }

    fun onClickBtnScores(view: View) {
        val intent = Intent(this, ListScoresActivity::class.java)
        startActivity(intent)
    }
}