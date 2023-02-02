package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity()
{
    lateinit var recyclerView: RecyclerView
    lateinit var list:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler)
        list = ArrayList()

        var layoutmanager:RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager=layoutmanager

        list.add(Model("Android","1000"))
        list.add(Model("Java","2000"))
        list.add(Model("Flutter","3000"))
        list.add(Model("Testing","4000"))

        var myAdapter = MyAdapter(applicationContext,list)
        recyclerView.adapter=myAdapter



    }
}