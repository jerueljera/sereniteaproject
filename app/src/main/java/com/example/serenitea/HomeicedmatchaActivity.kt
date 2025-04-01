package com.example.serenitea

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class HomeicedmatchaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_homeicedmatcha)

        // Ensure the correct root view is used for edge-to-edge display
        val rootView = findViewById<View>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Navigation back to HomeActivity
        findViewById<TextView>(R.id.backhome_icedmatcha).setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Quantity adjustment logic
        val quantityTextView: TextView = findViewById(R.id.textView178)
        val increaseButton: TextView = findViewById(R.id.textView176) // "+" button
        val decreaseButton: TextView = findViewById(R.id.textView182) // "-" button

        var quantity = 1 // Default quantity

        // Increase quantity
        increaseButton.setOnClickListener {
            quantity++
            quantityTextView.text = String.format(Locale.getDefault(), "%d", quantity)
        }

        // Decrease quantity but not below 1
        decreaseButton.setOnClickListener {
            if (quantity > 1) {
                quantity--
                quantityTextView.text = String.format(Locale.getDefault(), "%d", quantity)
            }
        }

        // Add to Cart Button Click - Navigates to MychartActivity
        findViewById<Button>(R.id.btn_icedmatcha).setOnClickListener {
            val intent = Intent(this, MyCartActivity::class.java)
            startActivity(intent)
        }
    }
}
