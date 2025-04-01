package com.example.serenitea

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CoffeeMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coffeemenulist)

        // Find the TextView by its ID
        val backButton: TextView = findViewById(R.id.backmenu)
        val menuAmericano: TextView = findViewById(R.id.menuamericano) // Get the TextView for Americano
        val menuMatcha: TextView = findViewById(R.id.menumatcha) // Get the TextView for Matcha
        val menuMocha: TextView = findViewById(R.id.menumocha) // Get the TextView for Mocha
        val menuPlainBlack: TextView = findViewById(R.id.menuplainblck) // Get the TextView for Plain Black
        val menuCappuccino: TextView = findViewById(R.id.menucappuccino) // Get the TextView for Cappuccino
        val menuCaramelMacchiato: TextView = findViewById(R.id.menucaramac) // Get the TextView for Caramel Macchiato
        val menuEspresso: TextView = findViewById(R.id.menuespresso) // Get the TextView for Espresso
        val menuLatte: TextView = findViewById(R.id.menulatte) // Get the TextView for Latte
        val menuHazelnut: TextView = findViewById(R.id.menuhazelnut) // Get the TextView for Hazelnut
        val menuChoco: TextView = findViewById(R.id.menuchoco) // Get the TextView for Chocolate

        // Set an OnClickListener to navigate back to HomeActivity
        backButton.setOnClickListener {
            // Start the HomeActivity
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()  // Optionally finish the current activity to remove it from the stack
        }

        // Set an OnClickListener for the Americano menu item
        menuAmericano.setOnClickListener {
            // Start the CafeAmericanoActivity
            val intent = Intent(this, CafeaamericanoActivity::class.java)
            startActivity(intent)
        }

        // Set an OnClickListener for the Matcha menu item
        menuMatcha.setOnClickListener {
            // Start the CafeMatchaActivity
            val intent = Intent(this, CafematchaActivity::class.java)
            startActivity(intent)
        }

        // Set an OnClickListener for the Mocha menu item
        menuMocha.setOnClickListener {
            // Start the CafeMochaActivity
            val intent = Intent(this, CafemochaActivity::class.java)
            startActivity(intent)
        }

        // Set an OnClickListener for the Plain Black menu item
        menuPlainBlack.setOnClickListener {
            // Start the CafePlainBlackActivity
            val intent = Intent(this, CafeplainblackActivity::class.java)
            startActivity(intent)
        }

        // Set an OnClickListener for the Cappuccino menu item
        menuCappuccino.setOnClickListener {
            // Start the CafeCappuccinoActivity
            val intent = Intent(this, CafecappuccinoActivity::class.java)
            startActivity(intent)
        }

        // Set an OnClickListener for the Caramel Macchiato menu item
        menuCaramelMacchiato.setOnClickListener {
            // Start the CafeCaramelMacchiatoActivity
            val intent = Intent(this, CafecaramelmacchiatoActivity::class.java)
            startActivity(intent)
        }

        // Set an OnClickListener for the Espresso menu item
        menuEspresso.setOnClickListener {
            // Start the CafeEspressoActivity
            val intent = Intent(this, CafeespressoActivity::class.java)
            startActivity(intent)
        }

        // Set an OnClickListener for the Latte menu item
        menuLatte.setOnClickListener {
            // Start the CafeLatteActivity
            val intent = Intent(this, CafelatteActivity::class.java)
            startActivity(intent)
        }

        // Set an OnClickListener for the Hazelnut menu item
        menuHazelnut.setOnClickListener {
            // Start the CafeHazelnutActivity
            val intent = Intent(this, CafehazelnutActivity::class.java)
            startActivity(intent)
        }

        // Set an OnClickListener for the Chocolate menu item
        menuChoco.setOnClickListener {
            // Start the CafeChocolateActivity
            val intent = Intent(this, CafechocolateActivity::class.java)
            startActivity(intent)
        }

        // Find the ImageView with id "listamericano"
        val americanoImageView: ImageView = findViewById(R.id.listamericano)

        // Set an OnClickListener to navigate to CafeAmericanoActivity when the image is clicked
        americanoImageView.setOnClickListener {
            val intent = Intent(this, CafeaamericanoActivity::class.java)
            startActivity(intent)

        }

        // Find the ImageView with id "listmatcha"
        val matchaImageView: ImageView = findViewById(R.id.listmatcha)

        // Set an OnClickListener to navigate to CafeMatchaActivity when the image is clicked
        matchaImageView.setOnClickListener {
            val intent = Intent(this, CafematchaActivity::class.java)
            startActivity(intent)
        }

        // Find the ImageView with id "listmocha"
        val mochaImageView: ImageView = findViewById(R.id.listmocha)

        // Find the TextView with id "menumocha"
        val mochaTextView: TextView = findViewById(R.id.menumocha)

        // Set an OnClickListener to navigate to CafeMochaActivity when the image is clicked
        mochaImageView.setOnClickListener {
            val intent = Intent(this, CafemochaActivity::class.java)
            startActivity(intent)
        }

        // Set an OnClickListener to navigate to CafeMochaActivity when the text is clicked
        mochaTextView.setOnClickListener {
            val intent = Intent(this, CafemochaActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView with id "plainbalck_list"
        val plainBlackTextView: TextView = findViewById(R.id.plainbalck_list)

        // Find the ImageView with id "listpb"
        val plainBlackImageView: ImageView = findViewById(R.id.listpb)

        // Set an OnClickListener to navigate to CafePlainBlackActivity when the text is clicked
        plainBlackTextView.setOnClickListener {
            val intent = Intent(this, CafeplainblackActivity::class.java)
            startActivity(intent)
        }

        // Set an OnClickListener to navigate to CafePlainBlackActivity when the image is clicked
        plainBlackImageView.setOnClickListener {
            val intent = Intent(this, CafeplainblackActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView with id "textView204"
        val cappuccinoTextView: TextView = findViewById(R.id.textView204)

        // Find the ImageView with id "listcappuccino"
        val cappuccinoImageView: ImageView = findViewById(R.id.listcappuccino)

        // Set an OnClickListener to navigate to CafeCappuccinoActivity when the text is clicked
        cappuccinoTextView.setOnClickListener {
            val intent = Intent(this, CafecappuccinoActivity::class.java)
            startActivity(intent)
        }

        // Set an OnClickListener to navigate to CafeCappuccinoActivity when the image is clicked
        cappuccinoImageView.setOnClickListener {
            val intent = Intent(this, CafecappuccinoActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView with id "menulist_mocha"
        val menuListMocha: TextView = findViewById(R.id.menulist_mocha)

        // Set an OnClickListener to navigate to CafeMochaActivity when the text is clicked
        menuListMocha.setOnClickListener {
            val intent = Intent(this, CafemochaActivity::class.java)
            startActivity(intent)
        }

        // Find the ImageView with id "caramelmac"
        val caramelMacImageView: ImageView = findViewById(R.id.caramelmac)

        // Set an OnClickListener to navigate to CafeCaramelMacchiatoActivity when the image is clicked
        caramelMacImageView.setOnClickListener {
            val intent = Intent(this, CafecaramelmacchiatoActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView with id "menulist_caramel"
        val menuListCaramel: TextView = findViewById(R.id.menulist_caramel)

        // Set an OnClickListener to navigate to CafeCaramelMacchiatoActivity when the text is clicked
        menuListCaramel.setOnClickListener {
            val intent = Intent(this, CafecaramelmacchiatoActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView with id "menulist_espresso"
        val menuListEspresso: TextView = findViewById(R.id.menulist_espresso)

        // Set an OnClickListener to navigate to CafeEspressoActivity when the text is clicked
        menuListEspresso.setOnClickListener {
            val intent = Intent(this, CafeespressoActivity::class.java)
            startActivity(intent)
        }

        // Find the ImageView with id "iamge_latte"
        val espressoImageView: ImageView = findViewById(R.id.iamge_latte)

        // Set an OnClickListener to navigate to CafeEspressoActivity when the image is clicked
        espressoImageView.setOnClickListener {
            val intent = Intent(this, CafeespressoActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView for Latte menu item
        val menuLatteTextView: TextView = findViewById(R.id.menulist_latte)

        // Set an OnClickListener to navigate to CafeLatteActivity when the text is clicked
        menuLatteTextView.setOnClickListener {
            val intent = Intent(this, CafelatteActivity::class.java)
            startActivity(intent)

        }

        // Find the ImageView with id "image_latte"
        val latteImageView: ImageView = findViewById(R.id.image_latte)

        // Set an OnClickListener to navigate to CafeLatteActivity when the image is clicked
        latteImageView.setOnClickListener {
            val intent = Intent(this, CafelatteActivity::class.java)
            startActivity(intent)

        }

        // Find the TextView for Hazelnut
        val menuHazelnutTextView: TextView = findViewById(R.id.menulist_hazel)

        // Set an OnClickListener to navigate to CafeHazelnutActivity when the text is clicked
        menuHazelnutTextView.setOnClickListener {
            val intent = Intent(this, CafehazelnutActivity::class.java)
            startActivity(intent)
        }

        // Find the ImageView with id "image_hazel"
        val hazelImageView: ImageView = findViewById(R.id.image_hazel)

        // Set an OnClickListener to navigate to CafeHazelnutActivity when the image is clicked
        hazelImageView.setOnClickListener {
            val intent = Intent(this, CafehazelnutActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView for Chocolate menu item
        val menuchoco: TextView = findViewById(R.id.menulist_choco) // Get the TextView for Chocolate

        // Set an OnClickListener for the Chocolate menu item
        menuChoco.setOnClickListener {
            // Start the CafeChocolateActivity
            val intent = Intent(this, CafechocolateActivity::class.java)
            startActivity(intent)
        }

        // Find the TextView for Chocolate menu item
        val menuListChoco: TextView = findViewById(R.id.menulist_choco) // Get the TextView for Chocolate

        // Set an OnClickListener for the Chocolate menu item (text)
        menuListChoco.setOnClickListener {
            // Start the CafeChocolateActivity
            val intent = Intent(this, CafechocolateActivity::class.java)
            startActivity(intent)
        }

        // Find the ImageView with id "iamge_choco" (fix the typo "iamge" to "image")
        val chocoImageView: ImageView = findViewById(R.id.iamge_choco) // Image for Chocolate

        // Set an OnClickListener for the Chocolate image item
        chocoImageView.setOnClickListener {
            // Start the CafeChocolateActivity when image is clicked
            val intent = Intent(this, CafechocolateActivity::class.java)
            startActivity(intent)
        }

    }
}

