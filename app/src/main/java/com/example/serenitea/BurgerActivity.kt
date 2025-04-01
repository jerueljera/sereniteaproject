package com.example.serenitea

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class BurgerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_burger)

        // Find the "back_burger" TextView
        val backBurger: TextView = findViewById(R.id.back_burger)

        // Set the OnClickListener to navigate to FoodMenuActivity
        backBurger.setOnClickListener {
            val intent = Intent(this, FoodmenulistActivity::class.java)
            startActivity(intent)
        }

        // Find views for number manipulation
        val numberBurger: TextView = findViewById(R.id.numberburge)
        val addBurger: TextView = findViewById(R.id.addburger)
        val minusBurger: TextView = findViewById(R.id.button10)

        // Increase number when addburger is clicked
        addBurger.setOnClickListener {
            var number = numberBurger.text.toString().toInt()
            number++
            numberBurger.text = String.format(Locale.getDefault(), "%d", number)
        }

        // Decrease number when button10 is clicked (ensuring it doesn't go below 1)
        minusBurger.setOnClickListener {
            var number = numberBurger.text.toString().toInt()
            if (number > 1) {
                number--
                numberBurger.text = String.format(Locale.getDefault(), "%d", number)
            }
        }

        // Handle edge-to-edge layout and insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Add functionality for Add to Cart button
        val addToCartButton = findViewById<Button>(R.id.btn_burger)
        addToCartButton.setOnClickListener {
            val intent = Intent(this, MyCartActivity::class.java)
            startActivity(intent)
        }
    }
}
