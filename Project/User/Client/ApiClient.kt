package com.example.finalproject_batch_1130.Client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient
{
    companion object
    {

        var BASE_URL="https://vyasprakruti.000webhostapp.com/GiftShop/"
        var retrofit: Retrofit? = null
        fun getapiclient(): Retrofit?
        {

            if (retrofit == null)
            {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return  retrofit
        }
    }

}