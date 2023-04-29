package com.example.test

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.test.databinding.ActivityDashboardBinding

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var list: MutableList<DashboardModel>
    private lateinit var apiInterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)

        Toast.makeText(
            applicationContext,
            "Welcome " + sharedPreferences.getString("mob", ""),
            Toast.LENGTH_LONG
        ).show()

        list = ArrayList()
        binding.recycler.layoutManager = GridLayoutManager(this, 2)
        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)
        val call: Call<List<DashboardModel>> = apiInterface.viewData()
        call.enqueue(object : Callback<List<DashboardModel>> {

            override fun onResponse(
                call: Call<List<DashboardModel>>,
                response: Response<List<DashboardModel>>
            ) {
                list = response.body() as MutableList<DashboardModel>
                val myAdapter = DashboardAdapter(applicationContext, list)
                binding.recycler.adapter = myAdapter
            }

            override fun onFailure(call: Call<List<DashboardModel>>, t: Throwable) {
                Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.i1 -> {
                sharedPreferences.edit().clear().apply()
                finish()
                startActivity(Intent(applicationContext, LoginActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}