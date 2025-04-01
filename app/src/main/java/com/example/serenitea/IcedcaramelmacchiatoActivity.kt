package com.example.serenitea

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IcedcaramelmacchiatoActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_icedcaramelmacchiato)

        // Find views by ID
        val quantityText = findViewById<TextView>(R.id.textView128)
        val addButton = findViewById<TextView>(R.id.addcaramelmac)
        val minusButton = findViewById<TextView>(R.id.minuscaramelmac)
        val addToCartButton = findViewById<TextView>(R.id.btn_icedcaramel)

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

        // Handle back button click
        findViewById<TextView>(R.id.back_caramel).setOnClickListener {
            val intent = Intent(this, IcedcoffeemenulistActivity::class.java)
            startActivity(intent)
            finish()  // Close this activity
        }

        // Navigate to MychartActivity when "Add to Cart" button is clicked
        addToCartButton.setOnClickListener {
            val intent = Intent(this, MyCartActivity::class.java)
            startActivity(intent)
        }

        // Set up window insets listener for edge-to-edge padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}