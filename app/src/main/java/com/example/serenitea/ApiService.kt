package com.example.serenitea

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    // User Registration
    @FormUrlEncoded
    @POST("register_user.php")
    fun registerUser(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<ApiResponse>

    // User Login
    @FormUrlEncoded
    @POST("login_user.php")
    fun loginUser(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    // Get Stock List
    @GET("get_stock.php")
    fun getStock(): Call<List<Stock>>

    // Create Order
    @FormUrlEncoded
    @POST("create_order.php")
    fun createOrder(
        @Field("user_id") userId: Int,
        @Field("stock_id") stockId: Int,
        @Field("quantity") quantity: Int
    ): Call<ApiResponse>

    // Add to Cart
    @POST("serenitea_api/add_to_cart.php")
    fun addToCartButton(@Body item: CartItem): Call<ResponseBody>

    // Get Cart Items
    @GET("serenitea_api/get_cart.php")
    fun getCartItems(): Call<CartResponse>
}
