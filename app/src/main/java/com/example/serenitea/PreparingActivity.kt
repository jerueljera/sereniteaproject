package com.example.serenitea

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PreparingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preparing)

        // Apply window insets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Back button to navigate to HomeActivity
        val backButton = findViewById<TextView>(R.id.back_blueberry)
        backButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // Finish current activity to prevent stacking
        }

        // Navigate to CompletedActivity
        val completed = findViewById<TextView>(R.id.cmplted)
        completed.setOnClickListener {
            val intent = Intent(this, CompletedActivity::class.java)
            startActivity(intent)
        }

        // Navigate to OutForDeliveryActivity
        val outForDelivery = findViewById<TextView>(R.id.outofd)
        outForDelivery.setOnClickListener {
            val intent = Intent(this, OutfordeliveryActivity::class.java)
            startActivity(intent)
        }
    }
}
