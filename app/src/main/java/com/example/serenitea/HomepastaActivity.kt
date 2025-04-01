package com.example.serenitea

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomepastaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_homepasta)

        // Apply edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find the TextView with id "backhome_pasta" and set an OnClickListener
        val backHomePastaTextView: TextView = findViewById(R.id.backhome_pasta)

        // Set an OnClickListener on the "backhome_pasta" TextView
        backHomePastaTextView.setOnClickListener {
            // Intent to go back to HomeActivity
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        // Find the Button with id "btn_pasta" and set an OnClickListener
        val addToCartButton: Button = findViewById(R.id.btn_pasta)

        // Set OnClickListener to navigate to MychartActivity
        addToCartButton.setOnClickListener {
            val intent = Intent(this, MyCartActivity::class.java)
            startActivity(intent)
        }
    }
}