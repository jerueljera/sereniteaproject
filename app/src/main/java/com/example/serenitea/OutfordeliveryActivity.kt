package com.example.serenitea

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView

class OutfordeliveryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_outfordelivery)

        // Handle edge-to-edge insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Back button to return to HomeActivity
        val backButton = findViewById<TextView>(R.id.back_blueberry)
        backButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // Finish current activity to prevent stacking
        }

        // Navigate to PreparingActivity
        val preparingTextView = findViewById<TextView>(R.id.prepparing)
        preparingTextView.setOnClickListener {
            val intent = Intent(this, PreparingActivity::class.java)
            startActivity(intent)
        }

        // Navigate to CompletedActivity
        val completedTextView = findViewById<TextView>(R.id.compledted)
        completedTextView.setOnClickListener {
            val intent = Intent(this, CompletedActivity::class.java)
            startActivity(intent)
        }
    }
}