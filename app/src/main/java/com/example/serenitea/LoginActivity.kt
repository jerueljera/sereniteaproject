package com.example.serenitea

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.util.TypedValue
import android.text.InputType
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Find the "Sign up" TextView and set OnClickListener
        val signUpTextView = findViewById<TextView>(R.id.sign_up)
        signUpTextView.setOnClickListener {
            navigateToSignUp()  // Navigate to SignUpActivity
        }

        // Find the "Forgot Password" TextView and set OnClickListener
        val forgotPasswordTextView = findViewById<TextView>(R.id.forgotpassword)
        forgotPasswordTextView.setOnClickListener {
            navigateToForgotPassword()  // Navigate to ForgotPasswordActivity
        }

        // Handle login functionality
        val loginButton = findViewById<Button>(R.id.btnlogin)
        val emailField = findViewById<EditText>(R.id.email_input)
        val passwordField = findViewById<EditText>(R.id.password_hint)

        // Set text size and color for EditText fields (email and password)
        emailField.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f)  // Set font size to 15sp
        passwordField.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f)  // Set font size to 15sp
        emailField.setTextColor(Color.BLACK)  // Set text color to black
        passwordField.setTextColor(Color.BLACK)  // Set text color to black

        // Set the input type for email field as normal text (so the email is visible)
        emailField.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS

        // Set the input type for password field as password (to hide the text)
        passwordField.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

        // Set OnFocusChangeListener to make sure the text size and color remain when focused
        setFocusChangeListener(emailField)
        setFocusChangeListener(passwordField)

        // Set OnClickListener for the login button
        loginButton.setOnClickListener {
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()

            // Check if email and password are entered
            if (email.isEmpty()) {
                emailField.error = "Email is required"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                passwordField.error = "Password is required"
                return@setOnClickListener
            }

            // Check if the email is valid (basic validation)
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailField.error = "Please enter a valid email"
                return@setOnClickListener
            }

            // Make the Retrofit call to login the user
            RetrofitClient.apiService.loginUser(email, password) // Updated reference
                .enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        if (response.body()?.status == "success") {
                            val user = response.body()?.user
                            Toast.makeText(this@LoginActivity, "Welcome ${user?.name}", Toast.LENGTH_SHORT).show()
                            // Navigate to HomeActivity after successful login
                            goToHome()
                        } else {
                            Toast.makeText(this@LoginActivity, "Login Failed", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(this@LoginActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }

    // Function to navigate to SignupActivity
    private fun navigateToSignUp() {
        Log.d("LoginActivity", "Navigating to SignUpActivity")
        val intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }

    // Function to navigate to ForgotPasswordActivity
    private fun navigateToForgotPassword() {
        Log.d("LoginActivity", "Navigating to ForgotPasswordActivity")
        val intent = Intent(this, ForgotpasswordActivity::class.java)
        startActivity(intent)
    }

    // Function to navigate to HomeActivity (login action)
    private fun goToHome() {
        Log.d("LoginActivity", "Navigating to HomeActivity")
        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
        startActivity(intent)
        finish()  // Close the LoginActivity after navigating to HomeActivity
    }

    // Helper function to set OnFocusChangeListener for fields (email & password)
    private fun setFocusChangeListener(editText: EditText) {
        editText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                // Ensure text size and color remain consistent when focused
                editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f)
                editText.setTextColor(Color.BLACK)
            }
        }
    }
}
