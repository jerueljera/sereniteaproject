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

class CroissantActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_croissant)

        // Back button to return to FoodMenuActivity
        val backCroissant: TextView = findViewById(R.id.back_croissant)
        backCroissant.setOnClickListener {
            val intent = Intent(this, FoodmenulistActivity::class.java)
            startActivity(intent)
        }

        // Number manipulation
        val numberCroissant: TextView = findViewById(R.id.textView98)
        val addCroissant: TextView = findViewById(R.id.addcroissant)
        val minusCroissant: TextView = findViewById(R.id.minuscroissant)

        addCroissant.setOnClickListener {
            var number = numberCroissant.text.toString().toInt()
            number++
            numberCroissant.text = number.toString()
        }

        minusCroissant.setOnClickListener {
            var number = numberCroissant.text.toString().toInt()
            if (number > 1) {
                number--
                numberCroissant.text = number.toString()
            }
        }

        // Navigate to MychartActivity when "Add to Cart" button is clicked
        val addToCartButton: Button = findViewById(R.id.btn_croissant)
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
