package com.example.roomdb.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.roomdb.Adapter.UserAdapter
import com.example.roomdb.Database.DatabaseClass
import com.example.roomdb.Entity.User
import com.example.roomdb.R
import com.example.roomdb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var db: DatabaseClass
    lateinit var list:MutableList<User>
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(binding.tool)
        db = Room.databaseBuilder(applicationContext, DatabaseClass::class.java, "myDatabase").allowMainThreadQueries().build()
        list = ArrayList()
        recyclerView = findViewById(R.id.recycler)

        var l1: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager=l1

        list =  db.daoClass().getUsers()

        var adapter = UserAdapter(list)
        recyclerView.adapter=adapter

        binding.fab.setOnClickListener {

            startActivity(Intent(applicationContext,AdduserActivity::class.java))
        }
    }
}