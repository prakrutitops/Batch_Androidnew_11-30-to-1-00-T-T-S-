package com.example.classprojectadmin.intefaces

import com.example.classprojectadmin.models.LoginModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {

    @FormUrlEncoded
    @POST("admin_login.php")
    fun loginData(
        @Field("admin_phone")
        phone: String?,
        @Field("admin_password")
        password: String?
    ): Call<LoginModel>
}