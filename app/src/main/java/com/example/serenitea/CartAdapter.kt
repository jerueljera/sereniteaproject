package com.example.serenitea

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.Gson

class CartAdapter(
    private val cartItems: MutableList<CartItem>,
    private val onItemSelected: (CartItem, Boolean) -> Unit
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    inner class CartViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemName: TextView = view.findViewById(R.id.itemName)
        val itemSize: TextView = view.findViewById(R.id.itemSize)
        val itemImage: ImageView = view.findViewById(R.id.itemImage)
        val quantityText: TextView = view.findViewById(R.id.quantityText)
        val btnMinus: ImageView = view.findViewById(R.id.btnMinus)
        val btnPlus: ImageView = view.findViewById(R.id.btnPlus)
        val checkBox: CheckBox = view.findViewById(R.id.checkBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cartItem = cartItems[position]

        holder.itemName.text = cartItem.name
        holder.itemSize.text = cartItem.size ?: "No Size" // Default text when size is null
        Glide.with(holder.itemView.context).load(cartItem.imageName).into(holder.itemImage)  // Load image
        holder.quantityText.text = cartItem.quantity.toString()  // Display quantity
        holder.checkBox.isChecked = cartItem.isChecked

        // Handle increase and decrease of quantity
        holder.btnMinus.setOnClickListener {
            if (cartItem.quantity > 1) {
                cartItem.quantity--
                holder.quantityText.text = cartItem.quantity.toString()  // Update the quantity text
                notifyItemChanged(position)
                saveCart(holder.itemView.context)
            }
        }

        holder.btnPlus.setOnClickListener {
            cartItem.quantity++
            holder.quantityText.text = cartItem.quantity.toString()  // Update the quantity text
            notifyItemChanged(position)
            saveCart(holder.itemView.context)
        }

        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            cartItem.isChecked = isChecked
            onItemSelected(cartItem, isChecked)
        }
    }

    override fun getItemCount(): Int = cartItems.size

    private fun saveCart(context: Context) {
        val sharedPreferences = context.getSharedPreferences("cart_prefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val json = Gson().toJson(cartItems)
        editor.putString("cart_items", json)
        editor.apply()
    }
}
