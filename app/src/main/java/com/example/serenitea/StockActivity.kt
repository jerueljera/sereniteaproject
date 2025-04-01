package com.example.serenitea

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StockActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stock)

        fetchStockData()
    }

    private fun fetchStockData() {
        RetrofitClient.apiService.getStock()  // Replaced instance with apiService
            .enqueue(object : Callback<List<Stock>> {
                override fun onResponse(call: Call<List<Stock>>, response: Response<List<Stock>>) {
                    if (response.isSuccessful && response.body() != null) {
                        val stockList = response.body()!!
                        Toast.makeText(this@StockActivity, "Stock Loaded! Items: ${stockList.size}", Toast.LENGTH_SHORT).show()
                        // TODO: Display stock data in RecyclerView
                    } else {
                        Toast.makeText(this@StockActivity, "Failed to load stock!", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<List<Stock>>, t: Throwable) {
                    Toast.makeText(this@StockActivity, "Error: ${t.localizedMessage}", Toast.LENGTH_SHORT).show()
                }
            })
    }
}
