package com.example.finalproject_batch_1130.Interface

import com.example.finalproject_batch_1130.Model.CategoryModel
import com.example.finalproject_batch_1130.Model.DashboardModel
import com.example.finalproject_batch_1130.Model.RegisterModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Apiinterface
{
    @FormUrlEncoded
    @POST("signup.php")
    fun registerdetail(
        @Field("firstname") firstname: String?,
        @Field("lastname") lastname: String?,
       @Field("gender") gender:String?,
        @Field("email") email: String?,
        @Field("phone") mobile: String?,
        @Field("password") password: String?,

        ): Call<Void>

    @FormUrlEncoded
    @POST("login.php")
    fun logindata(
        @Field("phone") mobile: String?,
        @Field("pass") password: String?
    ): Call<RegisterModel>

    @GET("giftsview.php")
    fun viewdata() : Call<List<DashboardModel>>


    @GET("flower_category_view.php")
    fun flowerviewdata() : Call<List<CategoryModel>>


    @GET("books_view.php")
    fun booksviewdata() : Call<List<CategoryModel>>



    @FormUrlEncoded
    @POST("wishlist.php")
    fun wishlistadd(
        @Field("gift_name") gift_name: String?,
        @Field("gift_price") gift_price: String?,
        @Field("gift_description") gift_description:String?,
        @Field("gift_image") gift_image: String?,


        ): Call<Void>

}