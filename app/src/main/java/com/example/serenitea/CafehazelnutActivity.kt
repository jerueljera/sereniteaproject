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

class CafehazelnutActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cafehazelnut)

        // Find views by ID
        val backButton = findViewById<TextView>(R.id.back_hazelnut)
        val quantityText = findViewById<TextView>(R.id.textView66)
        val addButton = findViewById<TextView>(R.id.addhazelnut)
        val minusButton = findViewById<TextView>(R.id.minushazelnut)
        val addToCartButton = findViewById<Button>(R.id.btnhazelnut) // Add to Cart button

        // Navigate back to CoffeeMenuActivity
        backButton.setOnClickListener {
            val intent = Intent(this, CoffeeMenuActivity::class.java)
            startActivity(intent)
            finish()
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
