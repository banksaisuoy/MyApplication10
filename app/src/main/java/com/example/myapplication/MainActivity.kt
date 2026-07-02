package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvWelcomeMessage: TextView
    private lateinit var btnClickMe: Button
    private val counterLogic = CounterLogic()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvWelcomeMessage = findViewById(R.id.tvWelcomeMessage)
        btnClickMe = findViewById(R.id.btnClickMe)

        btnClickMe.setOnClickListener {
            counterLogic.increment()
            tvWelcomeMessage.text = getString(R.string.click_count_format, counterLogic.count)
        }
    }
}
