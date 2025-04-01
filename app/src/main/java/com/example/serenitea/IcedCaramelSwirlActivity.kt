package com.example.serenitea

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IcedCaramelSwirlActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_icedcaramelswirl)

        // Find views by ID
        val quantityText = findViewById<TextView>(R.id.textView135)
        val addButton = findViewById<TextView>(R.id.addcaramels)
        val minusButton = findViewById<TextView>(R.id.minuscaramels)
        val backSwirl = findViewById<TextView>(R.id.backswirl)
        val addToCartButton = findViewById<TextView>(R.id.button77) // Add to Cart button

        // Increase quantity
        addButton.setOnClickListener {
            val quantity = quantityText.text.toString().toInt() + 1
            quantityText.text = quantity.toString()
        }

        // Decrease quantity (minimum 1)
        minusButton.setOnClickListener {
            val quantity = quantityText.text.toString().toInt()
            if (quantity > 1) {
                quantityText.text = (quantity - 1).toString()
            }
        }

        // Back button functionality
        backSwirl.setOnClickListener {
            val intent = Intent(this, IcedcoffeemenulistActivity::class.java)
            startActivity(intent)
            finish() // Close this activity
        }

        // Add to Cart button functionality
        addToCartButton.setOnClickListener {
            val intent = Intent(this, MyCartActivity::class.java)
            startActivity(intent)
        }

        // Handle edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}