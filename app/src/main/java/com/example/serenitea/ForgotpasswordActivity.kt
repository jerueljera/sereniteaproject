package com.example.serenitea

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class ForgotpasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)  // Ensure this is your correct layout file

        val sendButton = findViewById<Button>(R.id.sendveri)
        val emailEditText = findViewById<EditText>(R.id.emailadd)
        val backButton = findViewById<TextView>(R.id.back_frgt)

        sendButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()

            if (email.isEmpty()) {
                emailEditText.error = "Email is required"
                return@setOnClickListener
            }

            val intent = Intent(this, VerificationActivity::class.java)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            navigateToLogin()
        }

        // Handle back press using the recommended method
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                navigateToLogin()
            }
        })
    }

    private fun navigateToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()  // Removes this activity from the back stack
    }
}