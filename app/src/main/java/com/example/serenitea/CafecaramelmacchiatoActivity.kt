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

class CafecaramelmacchiatoActivity : AppCompatActivity() {
    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cafecaramelmacchiato)

        // Back button functionality
        val backButton = findViewById<TextView>(R.id.backbttn)
        backButton.setOnClickListener {
            val intent = Intent(this, CoffeeMenuActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Quantity management
        val quantityText: TextView = findViewById(R.id.textView48)
        val addButton: TextView = findViewById(R.id.addcaramelmac)
        val minusButton: TextView = findViewById(R.id.minuscaramelmac)

        // Increase quantity when add button is clicked
        addButton.setOnClickListener {
            var quantity = quantityText.text.toString().toInt()
            quantity++
            quantityText.text = String.format("%d", quantity) // Locale-safe number formatting
        }

        // Decrease quantity when minus button is clicked (stops at 1)
        minusButton.setOnClickListener {
            var quantity = quantityText.text.toString().toInt()
            if (quantity > 1) {
                quantity--
                quantityText.text = String.format("%d", quantity) // Locale-safe number formatting
            }
        }

        // Add to Cart button functionality
        val addToCartButton = findViewById<Button>(R.id.btnsmall_caramelmac)
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
