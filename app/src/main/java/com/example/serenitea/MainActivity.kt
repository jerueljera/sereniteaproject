package com.example.serenitea

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val stockButton: Button = findViewById(R.id.btnStock)
        val orderButton: Button = findViewById(R.id.btnOrder)

        stockButton.setOnClickListener {
            startActivity(Intent(this, StockActivity::class.java))
        }

        orderButton.setOnClickListener {
            startActivity(Intent(this, OrderActivity::class.java))
        }

        // Fetch stock data from API
        RetrofitClient.apiService.getCartItems().enqueue(object : Callback<CartResponse> {
            override fun onResponse(call: Call<CartResponse>, response: Response<CartResponse>) {
                if (response.isSuccessful) {
                    Log.d("API_SUCCESS", "Cart Items: ${response.body()}")
                } else {
                    Log.e("API_ERROR", "Response Error: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<CartResponse>, t: Throwable) {
                Log.e("API_ERROR", "Failed to connect: ${t.message}")
            }
        })
    }
}
