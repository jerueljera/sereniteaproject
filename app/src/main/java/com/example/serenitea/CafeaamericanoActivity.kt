package com.example.serenitea

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CafeaamericanoActivity : AppCompatActivity() {
    private var quantity = 1
    private var price = 100
    private var selectedSize = "Small"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cafeaamericano)

        val btnSmall = findViewById<Button>(R.id.btnsmall_americano)
        val btnMedium = findViewById<Button>(R.id.btnmedium_americano)
        val btnLarge = findViewById<Button>(R.id.btnlarge_americano)
        val txtPrice = findViewById<TextView>(R.id.textView36)
        val txtQuantity = findViewById<TextView>(R.id.textView35)
        val btnMinus = findViewById<TextView>(R.id.minusamericano)
        val btnAdd = findViewById<TextView>(R.id.addamericano)
        val btnAddToCart = findViewById<Button>(R.id.btn_americano)
        val cafeaamericanoText: TextView = findViewById(R.id.textView34)
        btnSmall.setOnClickListener {
            selectedSize = "Small"
            price = 100
            txtPrice.text = "Php $price"
        }

        btnMedium.setOnClickListener {
            selectedSize = "Medium"
            price = 110
            txtPrice.text = "Php $price"
        }

        btnLarge.setOnClickListener {
            selectedSize = "Large"
            price = 120
            txtPrice.text = "Php $price"
        }

        btnMinus.setOnClickListener {
            if (quantity > 1) {
                quantity--
                txtQuantity.text = quantity.toString()
            }
        }

        btnAdd.setOnClickListener {
            quantity++
            txtQuantity.text = quantity.toString()
        }

        btnAddToCart.setOnClickListener {
            Toast.makeText(this, "$quantity x Cafe Americano ($selectedSize) added to cart", Toast.LENGTH_SHORT).show()
        }

        val btnBack: TextView = findViewById(R.id.back_americano)
        btnBack.setOnClickListener {
            finish() // Closes the activity and goes back
        }

    }
}