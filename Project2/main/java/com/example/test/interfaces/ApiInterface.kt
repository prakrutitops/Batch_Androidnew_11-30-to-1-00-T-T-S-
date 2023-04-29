package com.example.test

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiInterface
{
    @FormUrlEncoded
    @POST("user_signup.php")
    fun registerdetail(
        @Field("firstname") firstname: String?,
        @Field("lastname") lastname: String?,
        @Field("gender") gender:String?,
        @Field("email") email: String?,
        @Field("phone") mobile: String?,
        @Field("password") password: String?,
        ): Call<Void>

    @FormUrlEncoded
    @POST("user_login.php")
    fun logindata(
        @Field("phone") mobile: String?,
        @Field("password") password: String?
    ): Call<RegisterModel>

    @GET("gifts_category_view.php")
    fun viewData(): Call<List<DashboardModel>>

    @GET("books_view.php")
    fun booksViewData(): Call<List<CategoryModel>>

    @GET("flowers_view.php")
    fun flowersViewData(): Call<List<CategoryModel>>

    @FormUrlEncoded
    @POST("add_data_to_wishlist.php")
    fun addDataToWishlist(
        @Field("gift_name") gift_name: String?,
        @Field("gift_description") gift_description: String?,
        @Field("gift_price") gift_price:String?,
        @Field("image") image: String?,
        @Field("mobile") mob: String?,
        ): Call<Void>

    @FormUrlEncoded
    @POST("add_data_to_cart.php")
    fun addDataToCart(
        @Field("gift_name") gift_name: String?,
        @Field("gift_description") gift_description: String?,
        @Field("gift_price") gift_price:String?,
        @Field("image") image: String?,
    ): Call<Void>

    @FormUrlEncoded
    @POST("viewwishlist.php")
    fun Wishlistviewdata(
        @Field("mobile") mobile: String?,

    ): Call<List<WishListModel>>

}