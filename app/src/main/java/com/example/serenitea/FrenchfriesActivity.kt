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

class FrenchfriesActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_frenchfries)

        // Find views for counter
        val numberFries: TextView = findViewById(R.id.textView98)
        val addFries: TextView = findViewById(R.id.addfries)
        val minusFries: TextView = findViewById(R.id.minusfries)

        // Increase number when addfries is clicked
        addFries.setOnClickListener {
            var number = numberFries.text.toString().toInt()
            number++
            numberFries.text = number.toString()
        }

        // Decrease number when minusfries is clicked (stops at 1)
        minusFries.setOnClickListener {
            var number = numberFries.text.toString().toInt()
            if (number > 1) {
                number--
                numberFries.text = number.toString()
            }
        }

        // Find the "frenchfries" TextView and set up back navigation
        val frenchFries: TextView = findViewById(R.id.frenchfries)
        frenchFries.setOnClickListener {
            val intent = Intent(this, FoodmenulistActivity::class.java)
            startActivity(intent)
        }

        // Find "Add to Cart" button and set up navigation to MychartActivity
        val addToCartButton: Button = findViewById(R.id.btn_frenchfries)
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
