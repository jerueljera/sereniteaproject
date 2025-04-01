package com.example.serenitea

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomelasagnaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_homelasagna)

        // Setting up edge-to-edge layout (if applicable)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find the back button (home_lasagna) and set an OnClickListener
        val backButton: TextView = findViewById(R.id.home_lasagna)
        backButton.setOnClickListener {
            // Close HomelasagnaActivity and return to the previous screen
            finish()
        }

        // Find the "Add to Cart" button (btn_lasagna) and set an OnClickListener
        val addToCartButton: Button = findViewById(R.id.btn_lasagna)
        addToCartButton.setOnClickListener {
            // Open MychartActivity
            val intent = Intent(this, MyCartActivity::class.java)
            startActivity(intent)
        }
    }
}