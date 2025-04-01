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

class SpaghettiActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spaghetti)

        // Find views for counter
        val numberSpaghetti: TextView = findViewById(R.id.textView98)
        val addSpaghetti: TextView = findViewById(R.id.addspaghetti)
        val minusSpaghetti: TextView = findViewById(R.id.minussppaghetti)
        val addToCartButton: Button = findViewById(R.id.btn_spaghetti)

        // Increase number when addspaghetti is clicked
        addSpaghetti.setOnClickListener {
            var number = numberSpaghetti.text.toString().toInt()
            number++
            numberSpaghetti.text = number.toString()
        }

        // Decrease number when minussppaghetti is clicked (stops at 1)
        minusSpaghetti.setOnClickListener {
            var number = numberSpaghetti.text.toString().toInt()
            if (number > 1) {
                number--
                numberSpaghetti.text = number.toString()
            }
        }

        // Navigate to MychartActivity when "Add to Cart" button is clicked
        addToCartButton.setOnClickListener {
            val intent = Intent(this, MyCartActivity::class.java)
            startActivity(intent)
        }

        // Find the "back_spaghetti" TextView and set up back navigation
        val backSpaghetti: TextView = findViewById(R.id.back_spaghetti)
        backSpaghetti.setOnClickListener {
            val intent = Intent(this, FoodmenulistActivity::class.java)
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