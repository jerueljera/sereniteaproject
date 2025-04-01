package com.example.serenitea

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Locale

class BlueberryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_blueberry)

        val backBlueberry: TextView = findViewById(R.id.back_blueberry)
        backBlueberry.setOnClickListener { finish() }

        val numberTextView: TextView = findViewById(R.id.numberblue)
        val addButton: TextView = findViewById(R.id.addbuttonblue)
        val minusButton: TextView = findViewById(R.id.minusbuttonblue)

        // Increase quantity
        addButton.setOnClickListener {
            val number = numberTextView.text.toString().toInt() + 1
            numberTextView.text = String.format(Locale.getDefault(), "%d", number)
        }

        // Decrease quantity (minimum = 1)
        minusButton.setOnClickListener {
            val number = numberTextView.text.toString().toInt()
            if (number > 1) {
                numberTextView.text = String.format(Locale.getDefault(), "%d", number - 1)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Add to Cart Button Click
        val addToCartButton: Button = findViewById(R.id.button8)
        addToCartButton.setOnClickListener {
            val itemName = findViewById<TextView>(R.id.textView185).text.toString()
            val itemSize = "Regular" // Change if size selection is dynamic
            val itemImage = "imageView3" // Change to actual image URL if needed
            val quantity = numberTextView.text.toString().toInt()
            val price = 5.99 // Replace with actual price
            val userId = 1 // Replace with actual user ID from SharedPreferences
            val stockId = 101 // Replace with actual stock ID from database

            val cartItem = CartItem(
                name = itemName,
                size = itemSize,
                price = price,
                imageName = itemImage,
                quantity = quantity,
                userId = userId,
                stockId = stockId
            )

            addToCart(cartItem)
        }
    }

    // Function to add item to cart via API
    private fun addToCart(cartItem: CartItem) {
        RetrofitClient.apiService.addToCartButton(cartItem).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@BlueberryActivity, "Item added to cart!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@BlueberryActivity, "Failed to add item", Toast.LENGTH_SHORT).show()
                    Log.e("Cart", "Error: ${response.errorBody()?.string() ?: "Unknown error"}")
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@BlueberryActivity, "Network error!", Toast.LENGTH_SHORT).show()
                Log.e("Cart", "Failure: ${t.message}")
            }
        })
    }
}
