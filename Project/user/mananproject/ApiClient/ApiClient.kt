package com.example.test

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient
{
    companion object
    {

        var BASE_URL="https://chiragjadav.000webhostapp.com/classproject/API/"
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