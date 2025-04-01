package com.example.serenitea

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CreamypastaActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_creamypasta)

        // Find the "backpasta" TextView
        val backPasta: TextView = findViewById(R.id.backpasta)
        backPasta.setOnClickListener {
            val intent = Intent(this, FoodmenulistActivity::class.java)
            startActivity(intent)
        }

        // Find views for number manipulation
        val numberPasta: TextView = findViewById(R.id.textView32)
        val addPasta: TextView = findViewById(R.id.addcreamy)
        val minusPasta: TextView = findViewById(R.id.minuscreamy)

        // Increase number when addcreamy is clicked
        addPasta.setOnClickListener {
            var number = numberPasta.text.toString().toInt()
            number++
            numberPasta.text = number.toString()
        }

        // Decrease number when minuscreamy is clicked (ensuring it doesn't go below 1)
        minusPasta.setOnClickListener {
            var number = numberPasta.text.toString().toInt()
            if (number > 1) {
                number--
                numberPasta.text = number.toString()
            }
        }

        // Add to Cart button (Navigates to MychartActivity)
        val addToCartButton: Button = findViewById(R.id.btn_pasta)
        addToCartButton.setOnClickListener {
            val intent = Intent(this, MyCartActivity::class.java)
            startActivity(intent)
        }

        // Handle edge-to-edge layout and insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
