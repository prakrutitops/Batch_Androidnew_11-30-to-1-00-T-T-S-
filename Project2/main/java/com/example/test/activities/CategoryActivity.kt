package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.test.databinding.ActivityCategoryBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryBinding
    lateinit var mutableList: MutableList<CategoryModel>
    private lateinit var apiInterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mutableList = ArrayList()
        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)

        val i = intent
        val position = i.getIntExtra("position", 1)
        Toast.makeText(applicationContext, "$position", Toast.LENGTH_SHORT).show()
        when(position) {

            0 -> {
                val call = apiInterface.booksViewData()
                call.enqueue(object: Callback<List<CategoryModel>> {
                    override fun onResponse(
                        call: Call<List<CategoryModel>>,
                        response: Response<List<CategoryModel>>
                    ) {
                        mutableList = response.body() as MutableList<CategoryModel>
                        val myAdapter = CategoryAdapter(applicationContext, mutableList)
                        binding.recyclerView.adapter = myAdapter
                    }

                    override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {
                        Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                    }
                })
            }

            1 -> {
                val call = apiInterface.booksViewData()
                call.enqueue(object: Callback<List<CategoryModel>> {
                    override fun onResponse(
                        call: Call<List<CategoryModel>>,
                        response: Response<List<CategoryModel>>
                    ) {
                        mutableList = response.body() as MutableList<CategoryModel>
                        val myAdapter = CategoryAdapter(applicationContext, mutableList)
                        binding.recyclerView.adapter = myAdapter
                    }

                    override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {
                        Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                    }
                })
            }

            2 -> {
                val call = apiInterface.booksViewData()
                call.enqueue(object: Callback<List<CategoryModel>> {
                    override fun onResponse(
                        call: Call<List<CategoryModel>>,
                        response: Response<List<CategoryModel>>
                    ) {
                        mutableList = response.body() as MutableList<CategoryModel>
                        val myAdapter = CategoryAdapter(applicationContext, mutableList)
                        binding.recyclerView.adapter = myAdapter
                    }

                    override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {
                        Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                    }
                })
            }

            3 -> {
            val call = apiInterface.booksViewData()
            call.enqueue(object: Callback<List<CategoryModel>> {
                override fun onResponse(
                    call: Call<List<CategoryModel>>,
                    response: Response<List<CategoryModel>>
                ) {
                    mutableList = response.body() as MutableList<CategoryModel>
                    val myAdapter = CategoryAdapter(applicationContext, mutableList)
                    binding.recyclerView.adapter = myAdapter
                }

                override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {
                    Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                }
            })
        }

            4 -> {
                val call = apiInterface.booksViewData()
                call.enqueue(object: Callback<List<CategoryModel>> {
                    override fun onResponse(
                        call: Call<List<CategoryModel>>,
                        response: Response<List<CategoryModel>>
                    ) {
                        mutableList = response.body() as MutableList<CategoryModel>
                        val myAdapter = CategoryAdapter(applicationContext, mutableList)
                        binding.recyclerView.adapter = myAdapter
                    }

                    override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {
                        Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                    }
                })
            }

            5 -> {
                val call = apiInterface.flowersViewData()
                call.enqueue(object: Callback<List<CategoryModel>> {
                    override fun onResponse(
                        call: Call<List<CategoryModel>>,
                        response: Response<List<CategoryModel>>
                    ) {
                        mutableList = response.body() as MutableList<CategoryModel>
                        val myAdapter = CategoryAdapter(applicationContext, mutableList)
                        binding.recyclerView.adapter = myAdapter
                    }

                    override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {
                        Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                    }
                })
            }

            6 -> {
                val call = apiInterface.flowersViewData()
                call.enqueue(object: Callback<List<CategoryModel>> {
                    override fun onResponse(
                        call: Call<List<CategoryModel>>,
                        response: Response<List<CategoryModel>>
                    ) {
                        mutableList = response.body() as MutableList<CategoryModel>
                        val myAdapter = CategoryAdapter(applicationContext, mutableList)
                        binding.recyclerView.adapter = myAdapter
                    }

                    override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {
                        Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                    }
                })
            }

            7 -> {
                val call = apiInterface.booksViewData()
                call.enqueue(object: Callback<List<CategoryModel>> {
                    override fun onResponse(
                        call: Call<List<CategoryModel>>,
                        response: Response<List<CategoryModel>>
                    ) {
                        mutableList = response.body() as MutableList<CategoryModel>
                        val myAdapter = CategoryAdapter(applicationContext, mutableList)
                        binding.recyclerView.adapter = myAdapter
                    }

                    override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {
                        Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                    }
                })
            }

            8 -> {
                val call = apiInterface.booksViewData()
                call.enqueue(object: Callback<List<CategoryModel>> {
                    override fun onResponse(
                        call: Call<List<CategoryModel>>,
                        response: Response<List<CategoryModel>>
                    ) {
                        mutableList = response.body() as MutableList<CategoryModel>
                        val myAdapter = CategoryAdapter(applicationContext, mutableList)
                        binding.recyclerView.adapter = myAdapter
                    }

                    override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {
                        Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                    }
                })
            }

            9 -> {
                val call = apiInterface.booksViewData()
                call.enqueue(object: Callback<List<CategoryModel>> {
                    override fun onResponse(
                        call: Call<List<CategoryModel>>,
                        response: Response<List<CategoryModel>>
                    ) {
                        mutableList = response.body() as MutableList<CategoryModel>
                        val myAdapter = CategoryAdapter(applicationContext, mutableList)
                        binding.recyclerView.adapter = myAdapter
                    }

                    override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {
                        Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}