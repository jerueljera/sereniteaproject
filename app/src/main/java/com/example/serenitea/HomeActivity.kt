package com.example.serenitea

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Log message for debugging
        Log.d("HomeActivity", "HomeActivity started!")

        // Find the TextView with id "coffee"
        val coffeeTextView: TextView = findViewById(R.id.coffee)
        coffeeTextView.setOnClickListener {
            // Intent to go to CoffeeMenuActivity
            val intent = Intent(this, CoffeeMenuActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView with id "food" (for food menu)
        val foodTextView: TextView = findViewById(R.id.foodlist)
        foodTextView.setOnClickListener {
            // Intent to go to FoodmenulistActivity
            val intent = Intent(this, FoodmenulistActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView with id "icedcoffemenu" to go to IcedcoffeemenulistActivity
        val icedCoffeeMenuTextView: TextView = findViewById(R.id.icedcoffee)
        icedCoffeeMenuTextView.setOnClickListener {
            // Intent to go to IcedcoffeemenulistActivity
            val intent = Intent(this, IcedcoffeemenulistActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView with id "useraccount" and set an OnClickListener
        val userAccountTextView: TextView = findViewById(R.id.useraccount)
        userAccountTextView.setOnClickListener {
            // Intent to go to UserAccountActivity
            val intent = Intent(this, UserAccountActivity::class.java)
            startActivity(intent)
        }

        // Find the ImageView with id "imageVcappiew8"
        val icedCappImageView: ImageView = findViewById(R.id.imageVcappiew8)

        // Set an OnClickListener to navigate to IcedcappActivity when the image is clicked
        icedCappImageView.setOnClickListener {
            val intent = Intent(this, IcedcappActivity::class.java)
            startActivity(intent)

        }

        // Find the ImageView with id "pasta"
        val pastaImageView: ImageView = findViewById(R.id.pasta)

        // Set an OnClickListener to navigate to HomepastaActivity when the image is clicked
        pastaImageView.setOnClickListener {
            val intent = Intent(this, HomepastaActivity::class.java)
            startActivity(intent)

        }

        // Find the TextView with id "homecafe" and set an OnClickListener
        val homeCafeTextView: TextView = findViewById(R.id.homematcha_cafe)
        homeCafeTextView.setOnClickListener {
            // Intent to go to MatchahomeActivity when "Cafe Matcha" is clicked
            val intent = Intent(this, MatchahomeActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView with id "home_ice" to go to IcedcappActivity
        val homeIceTextView: TextView = findViewById(R.id.home_ice)
        homeIceTextView.setOnClickListener {
            // Intent to go to IcedcappActivity
            val intent = Intent(this, IcedcappActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView with id "cremypasta" to go to HomepastaActivity
        val creamyPastaTextView: TextView = findViewById(R.id.cremypasta)
        creamyPastaTextView.setOnClickListener {
            // Intent to go to HomepastaActivity
            val intent = Intent(this, HomepastaActivity::class.java)
            startActivity(intent)
        }

        // Find the ImageView by its ID
        val ImageView: ImageView = findViewById(R.id.imageView2)

        // Set the OnClickListener for the image
        ImageView.setOnClickListener {
            // Create an Intent to navigate to CafeMenuListActivity
            val intent = Intent(this, CoffeeMenuActivity::class.java)
            startActivity(intent)
        }

        // Find the ImageView by its ID
        val imageView: ImageView = findViewById(R.id.imageView6)

        // Set the OnClickListener for the image
        imageView.setOnClickListener {
            // Create an Intent to navigate to FoodMenuListActivity
            val intent = Intent(this, FoodmenulistActivity::class.java)
            startActivity(intent)
        }

        // Find the ImageView with id "imageViewlasagna17"
        val lasagnaImageView: ImageView = findViewById(R.id.imageViewlasagna17)

        // Set an OnClickListener to navigate to HomelasagnaActivity when the image is clicked
        lasagnaImageView.setOnClickListener {
            val intent = Intent(this, HomelasagnaActivity::class.java)
            startActivity(intent)

        }
        // Find the TextView with id "Llasagna" to go to HomelasagnaActivity
        val lasagnaTextView: TextView = findViewById(R.id.Llasagna)
        lasagnaTextView.setOnClickListener {
            // Intent to go to HomelasagnaActivity
            val intent = Intent(this, HomelasagnaActivity::class.java)
            startActivity(intent)
        }

        // Find the ImageView and TextView with id "homemocha" to go to HomeMochaActivity
        val mochaImageView: ImageView = findViewById(R.id.imageViewmocha20)
        val mochaTextView: TextView = findViewById(R.id.homemocha)

        // Define the OnClickListener to navigate to HomemochaActivity
        val mochaClickListener = { _: View ->
            val intent = Intent(this, Homemocha::class.java)
            startActivity(intent)
        }

        // Set the listener to both the ImageView and TextView
        mochaImageView.setOnClickListener(mochaClickListener)
        mochaTextView.setOnClickListener(mochaClickListener)

        // Find the ImageView and TextView with id "homelatte" and navigate to HomelatteActivity
        val latteImageView: ImageView = findViewById(R.id.imageViewlatte33)
        val latteTextView: TextView = findViewById(R.id.homelatte)
        val latteSizeTextView: TextView = findViewById(R.id.lattesize)

        // Define the OnClickListener to navigate to HomelatteActivity
        val latteClickListener = { _: View ->
            val intent = Intent(this, HomelatteActivity::class.java)
            startActivity(intent)
        }

        // Set the listener to both the ImageView and TextViews
        latteImageView.setOnClickListener(latteClickListener)
        latteTextView.setOnClickListener(latteClickListener)
        latteSizeTextView.setOnClickListener(latteClickListener)

        // Find the ImageView and TextViews for "homeplainblack" and navigate to HomepbActivity
        val homePlainBlackTextView: TextView = findViewById(R.id.homeplainblack)
        val homePlainBlackSizeTextView: TextView = findViewById(R.id.sizepb)
        val homePlainBlackImageView: ImageView = findViewById(R.id.imageViewpb65)

        // Define the OnClickListener to navigate to HomeplainblackActivity
        val homePlainBlackClickListener = { _: View ->
            val intent = Intent(this, Homeplainblack::class.java)
            startActivity(intent)
        }

        // Set the listener to the TextViews and ImageView for "homeplainblack"
        homePlainBlackTextView.setOnClickListener(homePlainBlackClickListener)
        homePlainBlackSizeTextView.setOnClickListener(homePlainBlackClickListener)
        homePlainBlackImageView.setOnClickListener(homePlainBlackClickListener)

        // Find the TextView with id "homemspaghetti1" and set an OnClickListener
        val homemSpaghetti1TextView: TextView = findViewById(R.id.homemspaghetti1)
        homemSpaghetti1TextView.setOnClickListener {
            // Intent to go to HomespaghettiActivity
            val intent = Intent(this, HomespaghettiActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView with id "textView200" and set an OnClickListener
        val textView200: TextView = findViewById(R.id.textView200)
        textView200.setOnClickListener {
            // Intent to go to HomespaghettiActivity
            val intent = Intent(this, HomespaghettiActivity::class.java)
            startActivity(intent)
        }

        // Find the ImageView with id "imagespaghettiView65" and set an OnClickListener
        val imagespaghettiView65: ImageView = findViewById(R.id.imagespaghettiView65)
        imagespaghettiView65.setOnClickListener {
            // Intent to go to HomespaghettiActivity
            val intent = Intent(this, HomespaghettiActivity::class.java)
            startActivity(intent)
        }
        // Find the ImageView, TextView, and TextView for "homematcha"
        val matchaImageView: ImageView = findViewById(R.id.imageViewpmmatcha64matcha)
        val matchaTextView1: TextView = findViewById(R.id.homematcha1)
        val matchaTextView2: TextView = findViewById(R.id.sizematcha)

        // Create the OnClickListener to navigate to HomematchaActivity
        val matchaClickListener = { _: View ->
            val intent = Intent(this, MatchahomeActivity::class.java)
            startActivity(intent)

        }

        // Set the listener to the ImageView and both TextViews
        matchaImageView.setOnClickListener(matchaClickListener)
        matchaTextView1.setOnClickListener(matchaClickListener)
        matchaTextView2.setOnClickListener(matchaClickListener)

        // Find the ImageView by ID for imageView6
        val homeImageView: ImageView = findViewById(R.id.imageView6)

        // Set an OnClickListener to navigate to IcedcoffeemenulistActivity when the image is clicked
        homeImageView.setOnClickListener {
            val intent = Intent(this, IcedcoffeemenulistActivity::class.java)
            startActivity(intent)
        }

        val homefood: ImageView = findViewById(R.id.homefood)
        homefood.setOnClickListener {
            // Intent to navigate to the food menu list activity
            val intent = Intent(this, FoodmenulistActivity::class.java)
            startActivity(intent)
        }

        // Find the ImageView with id "mycart"
        val myCartImageView: ImageView = findViewById(R.id.mycart)
        myCartImageView.setOnClickListener {
            // Navigate to MyCartActivity
            val intent = Intent(this, MyCartActivity::class.java)
            startActivity(intent)
        }

        // Find the ImageView with id "pay"
        val payImageView: ImageView = findViewById(R.id.pay)
        payImageView.setOnClickListener {
            // Navigate to PreparingActivity
            val intent = Intent(this, PreparingActivity::class.java)
            startActivity(intent)
        }
    }
}

