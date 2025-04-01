package com.example.serenitea

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class CafecappuccinoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cafecappuccnino) // Ensure correct layout name

        val btnAddToCart = findViewById<Button>(R.id.btn_cappuccino)
        btnAddToCart.setOnClickListener {
            val intent = Intent(this, MyCartActivity::class.java)
            startActivity(intent)
        }

        val backButton = findViewById<TextView>(R.id.btnback_cappuccino)
        backButton.setOnClickListener {
            val intent = Intent(this, CoffeeMenuActivity::class.java)
            startActivity(intent)
            finish()
        }

        val quantityText: TextView = findViewById(R.id.textView39)
        val addButton: TextView = findViewById(R.id.addcappuccino)
        val minusButton: TextView = findViewById(R.id.minuscappucino)

        addButton.setOnClickListener {
            val quantity = (quantityText.text.toString().toIntOrNull() ?: 1) + 1
            quantityText.text = String.format(Locale.getDefault(), "%d", quantity)
        }

        minusButton.setOnClickListener {
            val quantity = (quantityText.text.toString().toIntOrNull() ?: 1)
            if (quantity > 1) {
                quantityText.text = String.format(Locale.getDefault(), "%d", quantity - 1)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
