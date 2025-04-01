package com.example.serenitea

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class VerificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

        val sendButton = findViewById<Button>(R.id.verification)

        sendButton.setOnClickListener {
            val intent = Intent(this@VerificationActivity, NewpasswordActivity::class.java)
            startActivity(intent)
        }
    }
}

class NewpasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newpassword)
    }
}
