package com.example.serenitea

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyCartActivity : AppCompatActivity() {

    private lateinit var recyclerViewCart: RecyclerView
    private lateinit var cartAdapter: CartAdapter
    private val cartList: MutableList<CartItem> = mutableListOf() // Changed `var` to `val`

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mycart)

        recyclerViewCart = findViewById(R.id.recyclerViewCart)
        recyclerViewCart.layoutManager = LinearLayoutManager(this)

        cartAdapter = CartAdapter(cartList) { _, _ -> } // Used `_` to avoid unused parameter warning
        recyclerViewCart.adapter = cartAdapter

        // Call API to fetch cart items
        fetchCartItems()
    }

    private fun fetchCartItems() {
        // Use apiService from RetrofitClient to call the getCartItems API
        val apiService = RetrofitClient.apiService
        apiService.getCartItems().enqueue(object : Callback<CartResponse> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<CartResponse>, response: Response<CartResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val cartItems = response.body()?.items ?: emptyList()
                    cartList.clear()
                    cartList.addAll(cartItems)
                    cartAdapter.notifyDataSetChanged()
                    Log.d("Cart", "Fetched cart items: $cartItems")
                } else {
                    Toast.makeText(this@MyCartActivity, "Failed to load cart items", Toast.LENGTH_SHORT).show()
                    Log.e("Cart", "Failed to fetch cart items: ${response.errorBody()?.string() ?: "Unknown error"}")
                }
            }

            override fun onFailure(call: Call<CartResponse>, t: Throwable) {
                Toast.makeText(this@MyCartActivity, "Error fetching cart", Toast.LENGTH_SHORT).show()
                Log.e("Cart", "Error: ${t.message}")
            }
        })
    }
}
