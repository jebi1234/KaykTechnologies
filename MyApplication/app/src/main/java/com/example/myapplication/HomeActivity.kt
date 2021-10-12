package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var Email: String? = intent.getStringExtra("email")

        val Display = findViewById<TextView>(R.id.welcome)

        Display.setText("Wellcome to \n "+Email)
    }
}