package com.example.serenitea

data class CartResponse(
    val success: Boolean,
    val items: List<CartItem>
)
