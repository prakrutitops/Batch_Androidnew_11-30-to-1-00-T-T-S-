package com.example.mananproject.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mananproject.*
import com.example.mananproject.databinding.ActivityDashboardBinding
import com.example.mananproject.databinding.ActivityLoginBinding
import com.example.test.ApiClient

import com.example.test.DashboardModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityDashboardBinding
    lateinit var sharedPreferences: SharedPreferences
    private lateinit var apiInterface: ApiInterface
    lateinit var list:MutableList<DashboardModel>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences=getSharedPreferences("user_session", Context.MODE_PRIVATE)


        Toast.makeText(applicationContext,"Welcome "+sharedPreferences.getString("mob",""),Toast.LENGTH_LONG).show()
        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        var layoutmanager:RecyclerView.LayoutManager = GridLayoutManager(this,2)
        binding.recycler.layoutManager=layoutmanager

        list = ArrayList()

        val call: Call<List<DashboardModel>> = apiInterface.viewData()

        call.enqueue(object :Callback<List<DashboardModel>>{
            override fun onResponse(
                call: Call<List<DashboardModel>>,
                response: Response<List<DashboardModel>>)
            {
                list = response.body() as MutableList<DashboardModel>
                val myAdapter = DashboardAdapter(applicationContext, list)
                binding.recycler.adapter = myAdapter
            }

            override fun onFailure(call: Call<List<DashboardModel>>, t: Throwable) {


            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.option,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.logout->
            {
                sharedPreferences.edit().clear().commit()
                finish()
                startActivity(Intent(applicationContext,LoginActivity::class.java))
            }
            R.id.i1->
            {
               var i = Intent(applicationContext, WishListActivity::class.java)
               startActivity(i)
            }
            R.id.i2->
            {
                var i = Intent(applicationContext, CartViewActivity::class.java)
                startActivity(i)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}