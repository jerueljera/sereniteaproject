package com.example.serenitea

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FoodmenulistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_foodmenulist)

        // Set up window insets for edge-to-edge UI
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.backmenufood)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find the back button (TextView)
        val backButton: TextView = findViewById(R.id.backmenufood)

        // Set an OnClickListener for the back button
        backButton.setOnClickListener {
            // Start the HomeActivity when the back button is clicked
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()  // Optionally, finish the current activity to remove it from the stack
        }

        // Find the menuburger TextView
        val menuBurgerTextView: TextView = findViewById(R.id.menuburger)

        // Set an OnClickListener for the menuburger TextView
        menuBurgerTextView.setOnClickListener {
            // Start the BurgerActivity when the menuburger is clicked
            val intent = Intent(this, BurgerActivity::class.java)
            startActivity(intent)
        }

        // Find the menufries TextView
        val menuFriesTextView: TextView = findViewById(R.id.menufries)

        // Set an OnClickListener for the menufries TextView
        menuFriesTextView.setOnClickListener {
            // Start the FrenchfriesActivity when the menufries is clicked
            val intent = Intent(this, FrenchfriesActivity::class.java)
            startActivity(intent)
        }

        // Find the pasta TextView
        val pastaTextView: TextView = findViewById(R.id.menupasta)

        // Set an OnClickListener for the pasta TextView
        pastaTextView.setOnClickListener {
            // Start the CreamypastaActivity when the pasta is clicked
            val intent = Intent(this, CreamypastaActivity::class.java)
            startActivity(intent)
        }

        // Find the lasagna TextView
        val lasagnaTextView: TextView = findViewById(R.id.menulasagna)

        // Set an OnClickListener for the lasagna TextView
        lasagnaTextView.setOnClickListener {
            // Start the LasagnaActivity when the lasagna is clicked
            val intent = Intent(this, LasagnaActivity::class.java)
            startActivity(intent)
        }

        // Find the menuensaymada TextView
        val menuEnsaymadaTextView: TextView = findViewById(R.id.menuensaymada)

        // Set an OnClickListener for the menuensaymada TextView
        menuEnsaymadaTextView.setOnClickListener {
            // Start the EnsaymadaActivity when the menuensaymada is clicked
            val intent = Intent(this, EnsaymadaActivity::class.java)
            startActivity(intent)
        }

        // Find the menutoasted TextView
        val menuToastedTextView: TextView = findViewById(R.id.menutoasted)

        // Set an OnClickListener for the menutoasted TextView
        menuToastedTextView.setOnClickListener {
            // Start the ToastedbreadActivity when the menutoasted is clicked
            val intent = Intent(this, ToastedbreadActivity::class.java)
            startActivity(intent)
        }

        // Find the menuspaghetti TextView
        val menuSpaghettiTextView: TextView = findViewById(R.id.menuspaghetti)

        // Set an OnClickListener for the menuspaghetti TextView
        menuSpaghettiTextView.setOnClickListener {
            // Start the SpaghettiActivity when the menuspaghetti is clicked
            val intent = Intent(this, SpaghettiActivity::class.java)
            startActivity(intent)
        }

        // Find the menucinnamo TextView
        val menuCinnamoTextView: TextView = findViewById(R.id.menucinnamo)

        // Set an OnClickListener for the menucinnamo TextView
        menuCinnamoTextView.setOnClickListener {
            // Start the CinamorollActivity when the menucinnamo is clicked
            val intent = Intent(this, CinnamorollActivity::class.java)
            startActivity(intent)
        }

        // Find the menublueberry TextView
        val menuBlueberryTextView: TextView = findViewById(R.id.menublueberry)

        // Set an OnClickListener for the menublueberry TextView
        menuBlueberryTextView.setOnClickListener {
            // Start the BlueberryActivity when the menublueberry is clicked
            val intent = Intent(this, BlueberryActivity::class.java)
            startActivity(intent)
        }

        // Find the menucroissant TextView
        val menuCroissantTextView: TextView = findViewById(R.id.menucroissant)

        // Set an OnClickListener for the menucroissant TextView
        menuCroissantTextView.setOnClickListener {
            // Start the CroissantActivity when the menucroissant is clicked
            val intent = Intent(this, CroissantActivity::class.java)
            startActivity(intent)
        }

        // Find the image_burger ImageView
        val burgerImageView: ImageView = findViewById(R.id.image_burger)

        // Set OnClickListener for image_burger ImageView
        burgerImageView.setOnClickListener {
            val intent = Intent(this, BurgerActivity::class.java)
            startActivity(intent)
        }

        // Find the list_burger TextView
        val burgerTextView: TextView = findViewById(R.id.list_burger)

        // Set OnClickListener for list_burger TextView
        burgerTextView.setOnClickListener {
            val intent = Intent(this, BurgerActivity::class.java)
            startActivity(intent)
        }

        // Find the image_fries ImageView
        val friesImageView: ImageView = findViewById(R.id.image_fries)

        // Set OnClickListener for image_fries ImageView
        friesImageView.setOnClickListener {
            // Navigate to FrenchFriesActivity when the ImageView is clicked
            val intent = Intent(this, FrenchfriesActivity::class.java)
            startActivity(intent)
        }

        // Find the list_fries TextView
        val friesTextView: TextView = findViewById(R.id.list_fries)

        // Set OnClickListener for list_fries TextView
        friesTextView.setOnClickListener {
            // Navigate to FrenchFriesActivity when the TextView is clicked
            val intent = Intent(this, FrenchfriesActivity::class.java)
            startActivity(intent)
        }

        // Navigate to CreamypastaActivity on both clicks
        listOf(R.id.image_creamy, R.id.list_creamy).forEach { id ->
            findViewById<View>(id).setOnClickListener {
                startActivity(Intent(this, CreamypastaActivity::class.java))
            }

            // Inside your Activity's onCreate method

            val imageLasagna: ImageView = findViewById(R.id.image_lasagna)
            val listLasagna: TextView = findViewById(R.id.list_lasagna)

            // Set onClickListeners
            imageLasagna.setOnClickListener {
                val intent = Intent(this, LasagnaActivity::class.java)
                startActivity(intent)
            }

            listLasagna.setOnClickListener {
                val intent = Intent(this, LasagnaActivity::class.java)
                startActivity(intent)
            }

            // Inside your Activity's onCreate method

            val imageEnsaymada: ImageView = findViewById(R.id.image_ensaymada)
            val listEnsaymada: TextView = findViewById(R.id.list_ensaymada)

            // Set onClickListeners
            imageEnsaymada.setOnClickListener {
                val intent = Intent(this, EnsaymadaActivity::class.java)
                startActivity(intent)
            }

            listEnsaymada.setOnClickListener {
                val intent = Intent(this, EnsaymadaActivity::class.java)
                startActivity(intent)
            }

            // Inside your Activity's onCreate method

            val imageToastedBread: ImageView = findViewById(R.id.image_toastedbread)
            val listToastedBread: TextView = findViewById(R.id.list_toastedbread)

            // Set onClickListeners
            imageToastedBread.setOnClickListener {
                val intent = Intent(this, ToastedbreadActivity::class.java)
                startActivity(intent)
            }

            listToastedBread.setOnClickListener {
                val intent = Intent(this, ToastedbreadActivity::class.java)
                startActivity(intent)
            }

            // Inside your Activity's onCreate method

            val imageSpaghetti: ImageView = findViewById(R.id.iamge_spaghetti)
            val listSpaghetti: TextView = findViewById(R.id.list_spaghetti)

            // Set onClickListeners
            imageSpaghetti.setOnClickListener {
                val intent = Intent(this, SpaghettiActivity::class.java)
                startActivity(intent)
            }

            listSpaghetti.setOnClickListener {
                val intent = Intent(this, SpaghettiActivity::class.java)
                startActivity(intent)
            }

            // Inside your Activity's onCreate method

            val imageCinnamoroll: ImageView = findViewById(R.id.image_cinnamoroll)
            val listCinnamoroll: TextView = findViewById(R.id.list_cinnamoroll)

            // Set onClickListeners
            imageCinnamoroll.setOnClickListener {
                val intent = Intent(this, CinnamorollActivity::class.java)
                startActivity(intent)
            }

            listCinnamoroll.setOnClickListener {
                val intent = Intent(this, CinnamorollActivity::class.java)
                startActivity(intent)
            }

            // Inside your Activity's onCreate method

            val imageBlueberry: ImageView = findViewById(R.id.image_blueberry)
            val listBlueberry: TextView = findViewById(R.id.list_blueberry)

            // Set onClickListeners
            imageBlueberry.setOnClickListener {
                val intent = Intent(this, BlueberryActivity::class.java)
                startActivity(intent)
            }

            listBlueberry.setOnClickListener {
                val intent = Intent(this, BlueberryActivity::class.java)
                startActivity(intent)
            }

            // Inside your Activity's onCreate method

            val imageCroissant: ImageView = findViewById(R.id.image_croissant)
            val listCroissant: TextView = findViewById(R.id.list_croissant)

            // Set onClickListeners
            imageCroissant.setOnClickListener {
                val intent = Intent(this, CroissantActivity::class.java)
                startActivity(intent)
            }

            listCroissant.setOnClickListener {
                val intent = Intent(this, CroissantActivity::class.java)
                startActivity(intent)
            }

        }
    }
}

