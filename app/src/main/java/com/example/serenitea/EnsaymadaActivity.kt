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

class EnsaymadaActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ensaymada)

        // Find the "backensaymada" TextView
        val backEnsaymada: TextView = findViewById(R.id.backensaymada)

        // Set the OnClickListener to navigate to FoodMenuActivity
        backEnsaymada.setOnClickListener {
            val intent = Intent(this, FoodmenulistActivity::class.java)
            startActivity(intent)
        }

        // Find views for counter
        val numberEnsaymada: TextView = findViewById(R.id.textView98)
        val addEnsaymada: TextView = findViewById(R.id.addensaymada)
        val minusEnsaymada: TextView = findViewById(R.id.minusnesaymada)

        // Increase number when addensaymada is clicked
        addEnsaymada.setOnClickListener {
            var number = numberEnsaymada.text.toString().toInt()
            number++
            numberEnsaymada.text = number.toString()
        }

        // Decrease number when minusensaymada is clicked (stops at 1)
        minusEnsaymada.setOnClickListener {
            var number = numberEnsaymada.text.toString().toInt()
            if (number > 1) {
                number--
                numberEnsaymada.text = number.toString()
            }
        }

        // Handle edge-to-edge layout and insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Add intent to navigate to MychartActivity when button15 (Add to Cart) is clicked
        val addToCartButton: Button = findViewById(R.id.button15)
        addToCartButton.setOnClickListener {
            val intent = Intent(this, MyCartActivity::class.java)
            startActivity(intent)
        }
    }
}
