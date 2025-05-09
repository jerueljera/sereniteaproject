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

class CafechocolateActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cafechocolate)

        // Find views by ID
        val backButton = findViewById<TextView>(R.id.back_chocolate)
        val quantityText = findViewById<TextView>(R.id.textView52)
        val addButton = findViewById<TextView>(R.id.addchoco)
        val minusButton = findViewById<TextView>(R.id.minuschoco)
        val addToCartButton = findViewById<Button>(R.id.btn_chocolate)

        // Navigate back to CoffeeMenuActivity
        backButton.setOnClickListener {
            val intent = Intent(this, CoffeeMenuActivity::class.java)
            startActivity(intent)
            finish() // Optional: Prevent returning to this activity
        }

        // Increase quantity
        addButton.setOnClickListener {
            var quantity = quantityText.text.toString().toInt()
            quantity++
            quantityText.text = quantity.toString()
        }

        // Decrease quantity (stops at 1)
        minusButton.setOnClickListener {
            var quantity = quantityText.text.toString().toInt()
            if (quantity > 1) {
                quantity--
                quantityText.text = quantity.toString()
            }
        }

        // Navigate to MychartActivity when "Add to Cart" is clicked
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
