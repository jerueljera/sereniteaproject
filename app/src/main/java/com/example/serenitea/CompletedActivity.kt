package com.example.serenitea

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView

class CompletedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_completed)

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
            finish()
        }

        // Navigate to OutfordeliveryActivity
        val outOfDeliveryTextView = findViewById<TextView>(R.id.outofdelevered)
        outOfDeliveryTextView.setOnClickListener {
            val intent = Intent(this, OutfordeliveryActivity::class.java)
            startActivity(intent)
        }

        // Navigate to PreparingActivity
        val preparingTextView = findViewById<TextView>(R.id.ppreparing)
        preparingTextView.setOnClickListener {
            val intent = Intent(this, PreparingActivity::class.java)
            startActivity(intent)
        }
    }
}