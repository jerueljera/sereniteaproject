package com.example.serenitea

data class ApiResponse(
    val success: Boolean,
    val message: String?,
    val error: String?
)