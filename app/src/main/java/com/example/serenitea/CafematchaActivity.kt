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

class CafematchaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cafematcha)

        val backButton = findViewById<TextView>(R.id.back_matcha)
        backButton.setOnClickListener { finish() } // Go back when clicked

        val quantityText = findViewById<TextView>(R.id.textView78) // Quantity display
        val addButton = findViewById<TextView>(R.id.addmatcha) // Increase quantity
        val minusButton = findViewById<TextView>(R.id.minusmatcha) // Decrease quantity

        // Increase quantity
        addButton.setOnClickListener {
            val quantity = quantityText.text.toString().toInt() + 1
            quantityText.text = String.format(Locale.getDefault(), "%d", quantity)
        }

        // Decrease quantity (minimum = 1)
        minusButton.setOnClickListener {
            val quantity = quantityText.text.toString().toInt()
            if (quantity > 1) {
                quantityText.text = String.format(Locale.getDefault(), "%d", quantity - 1)
            }
        }

        // Add to Cart button
        val addToCartButton = findViewById<Button>(R.id.btn_matcha)
        addToCartButton.setOnClickListener {
            val productName = findViewById<TextView>(R.id.textView).text.toString() // Get name dynamically
            val productSize = "Medium" // Change if needed
            val productImage = "matcha_image" // Replace with actual image URL
            val quantity = quantityText.text.toString().toInt()
            val price = 4.99 // Replace with actual price
            val userId = 1 // Replace with actual user ID from session
            val stockId = 102 // Replace with actual stock ID

            val cartItem = CartItem(
                name = productName,
                size = productSize,
                price = price,
                imageName = productImage,
                quantity = quantity,
                userId = userId,
                stockId = stockId
            )

            addToCart(cartItem)
        }

        // Handle edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Function to add item to cart via API
    private fun addToCart(cartItem: CartItem) {
        RetrofitClient.apiService.addToCartButton(cartItem).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@CafematchaActivity, "Item added to cart!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@CafematchaActivity, "Failed to add item", Toast.LENGTH_SHORT).show()
                    Log.e("Cart", "Error: ${response.errorBody()?.string() ?: "Unknown error"}")
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@CafematchaActivity, "Network error!", Toast.LENGTH_SHORT).show()
                Log.e("Cart", "Failure: ${t.message}")
            }
        })
    }
}
