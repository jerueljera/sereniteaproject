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

class CafeplainblackActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cafeplainblack)

        // Find views by ID
        val backButton = findViewById<TextView>(R.id.backplain)
        val quantityText = findViewById<TextView>(R.id.textView96)
        val addButton = findViewById<TextView>(R.id.addplain)
        val minusButton = findViewById<TextView>(R.id.minusplain)
        val addToCartButton = findViewById<Button>(R.id.btn_plainblack) // Ensure button8 exists in XML

        // Navigate back to CoffeeMenuActivity
        backButton.setOnClickListener {
            val intent = Intent(this, CoffeeMenuActivity::class.java)
            startActivity(intent)
            finish() // Prevent returning to this activity
        }

        // Increase quantity
        addButton.setOnClickListener {
            val quantity = quantityText.text.toString().toInt() + 1
            quantityText.text = quantity.toString()
        }

        // Decrease quantity (stops at 1)
        minusButton.setOnClickListener {
            val quantity = quantityText.text.toString().toInt()
            if (quantity > 1) {
                quantityText.text = (quantity - 1).toString()
            }
        }

        // Navigate to MychartActivity when Add to Cart is clicked
        addToCartButton.setOnClickListener {
            val intent = Intent(this, MyCartActivity::class.java)
            startActivity(intent)
        }

        // Optional: Handle window insets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}