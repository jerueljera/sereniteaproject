package com.example.serenitea

data class LoginResponse(
    val status: String,  // Change success -> status (string)
    val message: String?,
    val user: User?
)

