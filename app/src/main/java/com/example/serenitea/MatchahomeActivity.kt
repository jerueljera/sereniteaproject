package com.example.serenitea

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MatchahomeActivity : AppCompatActivity() {
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matchahome) // Ensure this is your correct layout file

        // Find the back button by its ID
        val backButton: TextView = findViewById(R.id.backmatcha_home) // Ensure ID matches XML

        // Set an OnClickListener on the back button
        backButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // Optional: This will close MatchahomeActivity after navigating to HomeActivity
        }

        // Find the "Add to Cart" button
        val addToCartButton: Button = findViewById(R.id.homebtnmatcha) // Ensure ID matches XML

        // Set an OnClickListener to navigate to MychartActivity
        addToCartButton.setOnClickListener {
            val intent = Intent(this, MyCartActivity::class.java)
            startActivity(intent)
        }
    }
}
