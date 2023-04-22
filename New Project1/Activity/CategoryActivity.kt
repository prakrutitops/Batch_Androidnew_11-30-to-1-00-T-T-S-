package com.example.finalproject_batch_1130.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject_batch_1130.Adapter.CategoryAdapter
import com.example.finalproject_batch_1130.Adapter.DashboardAdapter
import com.example.finalproject_batch_1130.Client.ApiClient
import com.example.finalproject_batch_1130.Interface.Apiinterface
import com.example.finalproject_batch_1130.Model.CategoryModel
import com.example.finalproject_batch_1130.Model.DashboardModel
import com.example.finalproject_batch_1130.R
import com.example.finalproject_batch_1130.databinding.ActivityCategoryBinding
import com.example.finalproject_batch_1130.databinding.ActivityDashboardBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityCategoryBinding
    lateinit var list:MutableList<CategoryModel>
    lateinit var apiinterface: Apiinterface

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i = intent
       var pos = i.getIntExtra("pos",111)

        Toast.makeText(applicationContext,""+pos,Toast.LENGTH_LONG).show()


        list = ArrayList()

        var layout : RecyclerView.LayoutManager = GridLayoutManager(this,2)
        binding.recycler.layoutManager = layout

        apiinterface = ApiClient.getapiclient()!!.create(Apiinterface::class.java)






        if(pos==0)
        {
            var call: Call<List<CategoryModel>> =  apiinterface.booksviewdata()

            call.enqueue(object : Callback<List<CategoryModel>> {
                override fun onResponse(call: Call<List<CategoryModel>>, response: Response<List<CategoryModel>>) {

                    list = response.body() as MutableList<CategoryModel>

                    var myAdapter = CategoryAdapter(applicationContext,list)
                    binding.recycler.adapter=myAdapter


                }

                override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {

                    Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
                }
            })
        }
        if(pos==1)
        {
            var call: Call<List<CategoryModel>> =  apiinterface.flowerviewdata()
            call.enqueue(object : Callback<List<CategoryModel>> {
                override fun onResponse(call: Call<List<CategoryModel>>, response: Response<List<CategoryModel>>) {

                    list = response.body() as MutableList<CategoryModel>

                    var myAdapter = CategoryAdapter(applicationContext,list)
                    binding.recycler.adapter=myAdapter


                }

                override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {

                    Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
                }
            })

        }
        if(pos ==2)
        {

        }
        if(pos ==3)
        {

        }
        if(pos ==4)
        {

        }
        if(pos ==5)
        {

        }
        if(pos ==6)
        {

        }
        if(pos ==7)
        {

        }
        if(pos ==8)
        {

        }


    }
}