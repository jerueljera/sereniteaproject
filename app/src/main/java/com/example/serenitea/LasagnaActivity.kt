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

class LasagnaActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lasagna)

        // Find views for counter
        val numberLasagna: TextView = findViewById(R.id.textView98)
        val addLasagna: TextView = findViewById(R.id.addlasagna)
        val minusLasagna: TextView = findViewById(R.id.minuslasagna)

        // Increase number when addlasagna is clicked
        addLasagna.setOnClickListener {
            var number = numberLasagna.text.toString().toInt()
            number++
            numberLasagna.text = number.toString()
        }

        // Decrease number when minuslasagna is clicked (stops at 1)
        minusLasagna.setOnClickListener {
            var number = numberLasagna.text.toString().toInt()
            if (number > 1) {
                number--
                numberLasagna.text = number.toString()
            }
        }

        // Find the "back_lasagna" TextView and set up back navigation
        val backLasagna: TextView = findViewById(R.id.back_lasagna)
        backLasagna.setOnClickListener {
            val intent = Intent(this, FoodmenulistActivity::class.java)
            startActivity(intent)
        }

        // Find the "Add to Cart" button and set up navigation to MychartActivity
        val addToCartButton: Button = findViewById(R.id.btn_lasagna)
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