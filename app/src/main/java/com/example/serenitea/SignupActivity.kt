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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // Find views
        val nameField = findViewById<EditText>(R.id.textView16)
        val emailField = findViewById<EditText>(R.id.textView17)
        val passwordField = findViewById<EditText>(R.id.textView18)
        val confirmPasswordField = findViewById<EditText>(R.id.textView19)
        val signUpButton = findViewById<Button>(R.id.btnsignup)
        val loginTextView = findViewById<TextView>(R.id.Login)

        // Set input type for password fields
        passwordField.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        confirmPasswordField.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

        // Apply focus behavior
        setFocusBehavior(nameField)
        setFocusBehavior(emailField)
        setFocusBehavior(passwordField)
        setFocusBehavior(confirmPasswordField)

        // Handle sign-up button click
        signUpButton.setOnClickListener {
            val name = nameField.text.toString().trim()
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()
            val confirmPassword = confirmPasswordField.text.toString().trim()

            if (name.isEmpty()) {
                nameField.error = "Name is required"
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                emailField.error = "Email is required"
                return@setOnClickListener
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailField.error = "Please enter a valid email"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                passwordField.error = "Password is required"
                return@setOnClickListener
            }

            if (password.length < 6) {
                passwordField.error = "Password must be at least 6 characters"
                return@setOnClickListener
            }

            if (confirmPassword.isEmpty()) {
                confirmPasswordField.error = "Please confirm your password"
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                confirmPasswordField.error = "Passwords do not match"
                return@setOnClickListener
            }

            // Call API to register the user
            RetrofitClient.apiService.registerUser(name, email, password)
                .enqueue(object : Callback<ApiResponse> {
                    override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                        if (response.body()?.success == true) {
                            Toast.makeText(this@SignupActivity, "Success", Toast.LENGTH_SHORT).show()
                            navigateToLogin() // Navigate to login after successful registration
                        } else {
                            Toast.makeText(this@SignupActivity, "Success: ${response.body()?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                        Toast.makeText(this@SignupActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                    }
                })
        }

        // Handle login link click
        loginTextView.setOnClickListener {
            navigateToLogin()
        }
    }

    private fun navigateToLogin() {
        val intent = Intent(this@SignupActivity, LoginActivity::class.java)
        startActivity(intent)
        finish() // Close the signup activity so the user can't return to it
    }

    // Helper function to maintain focus behavior
    private fun setFocusBehavior(editText: EditText) {
        editText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                editText.setTextColor(Color.BLACK)
                editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f)
            }
        }
    }
}
