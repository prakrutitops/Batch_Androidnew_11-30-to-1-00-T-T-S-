package com.example.mananproject.Activity

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mananproject.ApiInterface
import com.example.mananproject.WishListAdapter
import com.example.mananproject.databinding.ActivityWishListBinding
import com.example.test.ApiClient
import com.example.test.WishListModel


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WishListActivity : AppCompatActivity()
{

    private lateinit var binding: ActivityWishListBinding
    lateinit var mutableList: MutableList<WishListModel>
    private lateinit var apiInterface: ApiInterface
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityWishListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mutableList = ArrayList()
        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        binding.recyclerWishlist.layoutManager = LinearLayoutManager(this)

         sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)
        var mob =sharedPreferences.getString("mob","")

        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)
        val call: Call<List<WishListModel>> = apiInterface.Wishlistviewdata(mob)
        call.enqueue(object : Callback<List<WishListModel>> {

            override fun onResponse(
                call: Call<List<WishListModel>>,
                response: Response<List<WishListModel>>
            )
            {
                mutableList = response.body() as MutableList<WishListModel>

                val myAdapter = WishListAdapter(applicationContext, mutableList)
                binding.recyclerWishlist.adapter = myAdapter

            }

            override fun onFailure(call: Call<List<WishListModel>>, t: Throwable) {
                Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
            }
        })

    }
}