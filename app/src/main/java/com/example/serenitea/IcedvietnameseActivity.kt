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

class IcedvietnameseActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_icedvietnamese)

        // Find views by ID
        val quantityText = findViewById<TextView>(R.id.textView151) // Ensure ID matches XML
        val addButton = findViewById<TextView>(R.id.addicedviet)
        val minusButton = findViewById<TextView>(R.id.minusicedviet)
        val backButton = findViewById<TextView>(R.id.back_icedvietnamese)
        val addToCartButton = findViewById<Button>(R.id.btn_icedvietnamese) // Ensure ID matches XML

        // Increase quantity when add button is clicked
        addButton.setOnClickListener {
            val quantity = quantityText.text.toString().toInt() + 1
            quantityText.text = quantity.toString()
        }

        // Decrease quantity when minus button is clicked (minimum 1)
        minusButton.setOnClickListener {
            val quantity = quantityText.text.toString().toInt()
            if (quantity > 1) {
                quantityText.text = (quantity - 1).toString()
            }
        }

        // Back button functionality
        backButton.setOnClickListener {
            val intent = Intent(this, IcedcoffeemenulistActivity::class.java)
            startActivity(intent)
            finish() // Close this activity
        }

        // "Add to Cart" button functionality
        addToCartButton.setOnClickListener {
            val intent = Intent(this, MyCartActivity::class.java)
            startActivity(intent)
        }

        // Handle edge-to-edge layout adjustments
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}