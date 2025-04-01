package com.example.serenitea

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class NewPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newpassword)  // Replace with your correct layout file name

        // Find the "Send" button in NewPasswordActivity
        val sendButton = findViewById<Button>(R.id.newpassword)

        // Set an OnClickListener for the "Send" button
        sendButton.setOnClickListener {
            // Create an Intent to navigate to LoginActivity
            val intent = Intent(this@NewPasswordActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
