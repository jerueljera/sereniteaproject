package com.example.serenitea

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("DEPRECATION")
class CheckoutActivity : AppCompatActivity() {
    private lateinit var confirmButton: Button
    private lateinit var nameInput: EditText
    private lateinit var addressInput: EditText
    private lateinit var totalPriceText: TextView
    private lateinit var itemNameTextView: TextView
    private lateinit var itemSizeTextView: TextView
    private lateinit var itemPriceTextView: TextView
    private lateinit var itemImageView: ImageView
    private var selectedItems = mutableListOf<CartItem>()

    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        confirmButton = findViewById(R.id.button)
        nameInput = findViewById(R.id.etName)
        addressInput = findViewById(R.id.etAddress)
        totalPriceText = findViewById(R.id.textView5)
        itemNameTextView = findViewById(R.id.itemNameTextView)
        itemSizeTextView = findViewById(R.id.itemSizeTextView)
        itemPriceTextView = findViewById(R.id.itemPriceTextView)
        itemImageView = findViewById(R.id.itemImageView)

        // Retrieve selected items from intent
        selectedItems = intent.getParcelableArrayListExtra("selectedItems") ?: mutableListOf()

        // Retrieve item details from intent
        val itemName = intent.getStringExtra("ITEM_NAME")
        val itemSize = intent.getStringExtra("ITEM_SIZE")
        val itemPrice = intent.getStringExtra("ITEM_PRICE")
        val itemImage = intent.getIntExtra("ITEM_IMAGE", 0)

        // Set values to views
        itemNameTextView.text = itemName
        itemSizeTextView.text = itemSize
        itemPriceTextView.text = itemPrice
        itemImageView.setImageResource(itemImage)

        // Display total price
        totalPriceText.text = "Total: ₱${calculateTotal()}"

        // Confirm button action
        confirmButton.setOnClickListener {
            confirmOrder()
        }
    }

    private fun calculateTotal(): Double {
        return selectedItems.sumOf { it.price }
    }

    private fun confirmOrder() {
        val name = nameInput.text.toString().trim()
        val address = addressInput.text.toString().trim()

        if (name.isEmpty() || address.isEmpty()) {
            Toast.makeText(this, "Please fill all details", Toast.LENGTH_SHORT).show()
            return
        }

        // Send each selected item as a separate order
        selectedItems.forEach { item ->
            sendOrderToServer(name, address, item)
        }
    }

    private fun sendOrderToServer(name: String, address: String, item: CartItem) {
        val apiService = RetrofitClient.apiService // Updated reference

        apiService.createOrder(
            userId = item.userId,
            stockId = item.stockId,
            quantity = item.quantity
        ).enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@CheckoutActivity, "Order Placed for $name at $address!", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this@CheckoutActivity, "Order Failed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Toast.makeText(this@CheckoutActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
