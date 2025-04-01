package com.example.serenitea

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Retrieve values dynamically from Intent extras
        val userId = intent.getIntExtra("USER_ID", -1)
        val stockId = intent.getIntExtra("STOCK_ID", -1)
        val quantity = intent.getIntExtra("QUANTITY", -1)

        // Validate the received values before making the API call
        if (userId > 0 && stockId > 0 && quantity > 0) {
            placeOrder(userId, stockId, quantity)
        } else {
            Toast.makeText(this, "Invalid order details", Toast.LENGTH_SHORT).show()
        }
    }

    private fun placeOrder(userId: Int, stockId: Int, quantity: Int) {
        RetrofitClient.apiService.createOrder(userId, stockId, quantity)
            .enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response.isSuccessful && response.body()?.success == true) {
                        Toast.makeText(this@OrderActivity, "Order Placed!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@OrderActivity, "Order Failed", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    Toast.makeText(this@OrderActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
    }
}
