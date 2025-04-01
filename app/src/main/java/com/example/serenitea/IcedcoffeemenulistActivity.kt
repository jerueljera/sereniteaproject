package com.example.serenitea

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class IcedcoffeemenulistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_icedcoffeemenulist)

        // Find the TextView by ID for iced Americano
        val icedAmericanoTextView: TextView = findViewById(R.id.menuiicedamericano)
        icedAmericanoTextView.setOnClickListener {
            val intent = Intent(this, IcedamericanoActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView by ID for iced cappuccino
        val icedCappuccinoTextView: TextView = findViewById(R.id.menuicedcap)
        icedCappuccinoTextView.setOnClickListener {
            val intent = Intent(this, IcedcappuccinoActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView for the back button
        val backButton: TextView = findViewById(R.id.backmenuicedcoffee)

            // Set an OnClickListener to navigate back to HomeActivity when the back button is clicked
        backButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()  // Optional: If you want to close the current activity (go back to home)
        }


        // Find the TextView by ID for iced caramel macchiato
        val icedCaramelMacchiatoTextView: TextView = findViewById(R.id.menucaramac)
        icedCaramelMacchiatoTextView.setOnClickListener {
            val intent = Intent(this, IcedcaramelmacchiatoActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView by ID for iced chocolate
        val icedChocolateTextView: TextView = findViewById(R.id.menuchocolate)
        icedChocolateTextView.setOnClickListener {
            val intent = Intent(this, icedChocolateTextView::class.java)
            startActivity(intent)
        }

        // Find the TextView by ID for iced hazelnut
        val icedHazelnutTextView: TextView = findViewById(R.id.menuicedchazelnut)
        icedHazelnutTextView.setOnClickListener {
            val intent = Intent(this, IcedhazelnutActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView by ID for iced latte
        val icedLatteTextView: TextView = findViewById(R.id.menueicedlatte)
        icedLatteTextView.setOnClickListener {
            val intent = Intent(this, IcedlatteActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView by ID for iced matcha
        val icedMatchaTextView: TextView = findViewById(R.id.menumatcha)
        icedMatchaTextView.setOnClickListener {
            val intent = Intent(this, IcedmatchaActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView by ID for iced plain black
        val icedPlainBlackTextView: TextView = findViewById(R.id.menuplainb1)
        icedPlainBlackTextView.setOnClickListener {
            val intent = Intent(this, IcedplainblackActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView by ID for iced Vietnamese coffee
        val icedVietnameseTextView: TextView = findViewById(R.id.menuicedviet)
        icedVietnameseTextView.setOnClickListener {
            val intent = Intent(this, IcedvietnameseActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView by ID for iced caramel swirl
        val icedCaramelSwirlTextView: TextView = findViewById(R.id.menucaraswirl)
        icedCaramelSwirlTextView.setOnClickListener {
            val intent = Intent(this, IcedCaramelSwirlActivity::class.java)
            startActivity(intent)
        }

        val icedamericanoActivity: TextView = findViewById(R.id.menulist_icedamericano)
        icedamericanoActivity.setOnClickListener {
            val intent = Intent(this, IcedamericanoActivity::class.java)
            startActivity(intent)
        }

        // Find the ImageView by ID for iced Americano
        val imageAmericanoImageView: ImageView = findViewById(R.id.image_americano)
        imageAmericanoImageView.setOnClickListener {
            val intent = Intent(this, IcedamericanoActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView by ID for iced Cappuccino
        val icedCappuccinoActivity: TextView = findViewById(R.id.menulist_icedcapp)
        icedCappuccinoActivity.setOnClickListener {
            val intent = Intent(this, IcedcappuccinoActivity::class.java)
            startActivity(intent)
        }
        // Find the ImageView by ID for iced Cappuccino
        val icedCappuccinoImageView: ImageView = findViewById(R.id.image_icedcapp)
        icedCappuccinoImageView.setOnClickListener {
            val intent = Intent(this, IcedcappuccinoActivity::class.java)
            startActivity(intent)
        }

        // Find the ImageView by ID for iced Caramel Macchiato
        val caramelMacchiatoImageView: ImageView = findViewById(R.id.menulist_mac)
        caramelMacchiatoImageView.setOnClickListener {
            val intent = Intent(this, IcedcaramelmacchiatoActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView by ID for Iced Caramel Macchiato
        val caramelMacchiatoTextView: TextView = findViewById(R.id.list_caramelmac)
        caramelMacchiatoTextView.setOnClickListener {
            val intent = Intent(this, IcedcaramelmacchiatoActivity::class.java)
            startActivity(intent)
        }

        // Find the ImageView by ID for Iced Caramel Swirl
        val caramelSwirlImageView: ImageView = findViewById(R.id.image_swirl)
        caramelSwirlImageView.setOnClickListener {
            val intent = Intent(this, IcedCaramelSwirlActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView by ID for Iced Caramel Swirl
        val caramelSwirlTextView: TextView = findViewById(R.id.list_swirl)
        caramelSwirlTextView.setOnClickListener {
            val intent = Intent(this, IcedCaramelSwirlActivity::class.java)
            startActivity(intent)
        }

        // Find the ImageView by ID for Iced Chocolate
        val icedChocolateImageView: ImageView = findViewById(R.id.image_icedchoco)
        icedChocolateImageView.setOnClickListener {
            val intent = Intent(this, IcedChocolateActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView by ID for Iced Chocolate
        val chocoTextView: TextView = findViewById(R.id.listicedchoco)
        chocoTextView.setOnClickListener {
            val intent = Intent(this, IcedChocolateActivity::class.java)
            startActivity(intent)
        }

        // Find the ImageView by ID for Iced Hazelnut
        val icedHazelnutImageView: ImageView = findViewById(R.id.image_icedhazel)
        icedHazelnutImageView.setOnClickListener {
            val intent = Intent(this, IcedhazelnutActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView by ID for Iced Hazelnut
        val hazelnutTextView: TextView = findViewById(R.id.list_hazelnut)
        hazelnutTextView.setOnClickListener {
            val intent = Intent(this, IcedhazelnutActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView by ID for Iced Latte
        val latteTextView: TextView = findViewById(R.id.list_icedlate)
        latteTextView.setOnClickListener {  // Use the correct variable name here
            val intent = Intent(this, IcedlatteActivity::class.java)
            startActivity(intent)
        }

        val icedLatteImage: ImageView = findViewById(R.id.image_icedlatte)

        icedLatteImage.setOnClickListener {
            val intent = Intent(this, IcedlatteActivity::class.java)
            startActivity(intent)
        }

        val icedMatchaText: TextView = findViewById(R.id.list_icedmatcha)
        icedMatchaText.setOnClickListener {
            val intent = Intent(this, IcedmatchaActivity::class.java)
            startActivity(intent)
        }

        val plainBlackText: TextView = findViewById(R.id.list_plainb)
        plainBlackText.setOnClickListener {
            val intent = Intent(this, IcedplainblackActivity::class.java)
            startActivity(intent)
        }

        val icedVietText: TextView = findViewById(R.id.list_icedviet)
        icedVietText.setOnClickListener {
            val intent = Intent(this, IcedvietnameseActivity::class.java)
            startActivity(intent)
        }

        val imageViet: ImageView = findViewById(R.id.image_viet)
        imageViet.setOnClickListener {
            val intent = Intent(this, IcedvietnameseActivity::class.java)
            startActivity(intent)
        }

        val imagePlainBlack: ImageView = findViewById(R.id.image_plainb)
        imagePlainBlack.setOnClickListener {
            val intent = Intent(this, IcedplainblackActivity::class.java)
            startActivity(intent)
        }

        val imageMatcha: ImageView = findViewById(R.id.image_matcha)

        // Make sure the image is clickable and set the click listener
        imageMatcha.isClickable = true
        imageMatcha.setOnClickListener {
            val intent = Intent(this, IcedmatchaActivity::class.java)
            startActivity(intent)
        }
    }
}
