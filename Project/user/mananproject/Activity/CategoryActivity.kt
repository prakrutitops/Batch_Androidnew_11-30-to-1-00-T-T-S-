package com.example.mananproject.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mananproject.ApiInterface
import com.example.mananproject.CategoryAdapter
import com.example.mananproject.R
import com.example.mananproject.databinding.ActivityCategoryBinding
import com.example.mananproject.databinding.ActivityDashboardBinding
import com.example.test.ApiClient

import com.example.test.CategoryModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityCategoryBinding
    lateinit var mutableList: MutableList<CategoryModel>
    private lateinit var apiInterface: ApiInterface
    lateinit var call:Call<List<CategoryModel>>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mutableList = ArrayList()
        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        binding.recycler.layoutManager = GridLayoutManager(this, 2)

        var i = intent
        var pos  =  i.getIntExtra("position",101)


        when(pos)
        {
            0->
            {
                 call = apiInterface.booksViewData()
            }
            1->
            {
                 call = apiInterface.flowersViewData()
            }

        }

        call.enqueue(object: Callback<List<CategoryModel>> {
            override fun onResponse(
                call: Call<List<CategoryModel>>,
                response: Response<List<CategoryModel>>
            ) {
                mutableList = response.body() as MutableList<CategoryModel>
                val myAdapter = CategoryAdapter(applicationContext, mutableList)
                binding.recycler.adapter = myAdapter
            }

            override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {
                Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
            }
        })
    }
}