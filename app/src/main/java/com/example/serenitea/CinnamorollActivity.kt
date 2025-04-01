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

class CinnamorollActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cinnamoroll)

        // Find the "backcinnamoroll" TextView
        val backCinnamoroll: TextView = findViewById(R.id.backcinnamoroll)

        // Set the OnClickListener to navigate to FoodMenuActivity
        backCinnamoroll.setOnClickListener {
            val intent = Intent(this, FoodmenulistActivity::class.java)
            startActivity(intent)
        }

        // Find views for number manipulation
        val numberCinnaroll: TextView = findViewById(R.id.textView98)
        val addCinnaroll: TextView = findViewById(R.id.addscinnaroll)
        val minusCinnaroll: TextView = findViewById(R.id.minusaddb)

        // Increase number when addscinnaroll is clicked
        addCinnaroll.setOnClickListener {
            var number = numberCinnaroll.text.toString().toInt()
            number++
            numberCinnaroll.text = number.toString()
        }

        // Decrease number when minuscinnaroll is clicked (ensuring it doesn't go below 1)
        minusCinnaroll.setOnClickListener {
            var number = numberCinnaroll.text.toString().toInt()
            if (number > 1) {
                number--
                numberCinnaroll.text = number.toString()
            }
        }

        // Find the "Add to Cart" button
        val addToCartButton: Button = findViewById(R.id.btn_cinnamoroll)

        // Set the OnClickListener to navigate to MychartActivity
        addToCartButton.setOnClickListener {
            val intent = Intent(this, MyCartActivity::class.java)
            startActivity(intent)
        }

        // Handle edge-to-edge layout and insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
