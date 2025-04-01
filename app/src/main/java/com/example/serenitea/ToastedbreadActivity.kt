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

class ToastedbreadActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_toastedbread)

        // Find views for counter
        val numberToasted: TextView = findViewById(R.id.textView98)
        val addToasted: TextView = findViewById(R.id.addtoasted)
        val minusToasted: TextView = findViewById(R.id.minustoasted)

        // Increase number when addtoasted is clicked
        addToasted.setOnClickListener {
            var number = numberToasted.text.toString().toInt()
            number++
            numberToasted.text = number.toString()
        }

        // Decrease number when minustoasted is clicked (stops at 1)
        minusToasted.setOnClickListener {
            var number = numberToasted.text.toString().toInt()
            if (number > 1) {
                number--
                numberToasted.text = number.toString()
            }
        }

        // Find the "back_toastedbread" TextView and set up back navigation
        val backToastedBread: TextView = findViewById(R.id.back_toastedbread)
        backToastedBread.setOnClickListener {
            val intent = Intent(this, FoodmenulistActivity::class.java)
            startActivity(intent)
        }

        // Navigate to MychartActivity when "Add to Cart" button is clicked
        val addToCartButton: Button = findViewById(R.id.btn_toastedbread)
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