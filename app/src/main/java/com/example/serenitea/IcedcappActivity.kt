package com.example.serenitea

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class IcedcappActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Find the back button by its ID
        val backButton: TextView = findViewById(R.id.homebtn_icedcap)

        // Set the click listener for the back button
        backButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // Closes IcedcappActivity
        }

        // Find the "Add to Cart" button by its ID
        val addToCartButton: Button = findViewById(R.id.button66)

        // Set the click listener for the "Add to Cart" button
        addToCartButton.setOnClickListener {
            val intent = Intent(this, MyCartActivity::class.java)
            startActivity(intent)
        }
    }
}
