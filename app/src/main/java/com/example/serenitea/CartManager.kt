package com.example.serenitea

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object CartManager {
    private const val PREF_NAME = "SereniteaCart"
    private const val CART_KEY = "cart_items"

    // Private method to get SharedPreferences
    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    // Private method to get the current list of cart items
    private fun getCart(context: Context): List<CartItem> {
        val prefs = getPreferences(context)
        val json = prefs.getString(CART_KEY, null)
        return if (json.isNullOrEmpty()) {
            emptyList() // Return an empty list if no cart data is found
        } else {
            try {
                val type = object : TypeToken<List<CartItem>>() {}.type
                Gson().fromJson(json, type) ?: emptyList() // Parse the cart JSON or return empty list
            } catch (e: Exception) {
                emptyList() // In case of error, return an empty list
            }
        }
    }

    // Public method to add an item to the cart
    fun addToCart(context: Context, cartItem: CartItem) {
        val cartList = getCart(context).toMutableList()
        val existingItem = cartList.find {
            it.name == cartItem.name && it.size == cartItem.size
        }
        if (existingItem != null) {
            existingItem.quantity += cartItem.quantity // Add the quantity to the existing item
        } else {
            cartList.add(cartItem) // Add the new item if not already in the cart
        }
        saveCart(context, cartList) // Save the updated cart list back to SharedPreferences
    }

    // Private method to save the cart data to SharedPreferences
    private fun saveCart(context: Context, cartList: List<CartItem>) {
        val prefs = getPreferences(context).edit()
        val json = Gson().toJson(cartList) // Convert cart list to JSON
        prefs.putString(CART_KEY, json).apply() // Save the JSON to SharedPreferences
    }
}
