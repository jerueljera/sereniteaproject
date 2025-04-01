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

class CafelatteActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cafelatte)

        val backButton = findViewById<TextView>(R.id.back_latte)
        val quantityText = findViewById<TextView>(R.id.textView74)
        val addButton = findViewById<TextView>(R.id.addlatte)
        val minusButton = findViewById<TextView>(R.id.minuslatte)
        val addToCartButton = findViewById<Button>(R.id.btnlatte) // Make sure this ID exists in XML

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

        addToCartButton.setOnClickListener {
            val intent = Intent(this, MyCartActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
