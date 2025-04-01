package com.example.serenitea

import android.annotation.SuppressLint
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class CartItem(
    val id: Int = 0,
    val name: String,
    val size: String?,
    val price: Double = 0.0,
    val imageName: String, // Renamed to follow camelCase convention
    var quantity: Int,
    val userId: Int = 0,
    val stockId: Int = 0,
    var isChecked: Boolean = false // Added isChecked for checkbox functionality
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString(),
        parcel.readDouble(),
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte() // Read boolean properly
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(size)
        parcel.writeDouble(price)
        parcel.writeString(imageName)
        parcel.writeInt(quantity)
        parcel.writeInt(userId)
        parcel.writeInt(stockId)
        parcel.writeByte(if (isChecked) 1 else 0) // Write boolean properly
    }

    override fun describeContents(): Int = 0

    @SuppressLint("DiscouragedApi")
    @Suppress("unused") // Suppresses the warning for unused functions
    fun getImageResId(context: Context): Int {
        val resId = context.resources.getIdentifier(imageName, "drawable", context.packageName)
        return if (resId != 0) resId else R.drawable.placeholder_image // Use a default image if not found
    }

    companion object CREATOR : Parcelable.Creator<CartItem> {
        override fun createFromParcel(parcel: Parcel): CartItem = CartItem(parcel)
        override fun newArray(size: Int): Array<CartItem?> = arrayOfNulls(size)

        // Save the cart items including checkBox state
        @Suppress("unused") // Suppresses warning for unused function
        fun saveCartItems(context: Context, cartList: List<CartItem>) {
            val sharedPreferences = context.getSharedPreferences("cart_prefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            val json = Gson().toJson(cartList)
            editor.putString("cart_items", json)
            editor.apply()
        }

        // Load the cart items with checkBox state
        @Suppress("unused") // Suppresses warning for unused function
        fun loadCartItems(context: Context): MutableList<CartItem> {
            val sharedPreferences = context.getSharedPreferences("cart_prefs", Context.MODE_PRIVATE)
            val json = sharedPreferences.getString("cart_items", null)
            return if (json != null) {
                val type = object : TypeToken<MutableList<CartItem>>() {}.type
                Gson().fromJson(json, type) ?: mutableListOf()
            } else {
                mutableListOf()
            }
        }
    }
}
