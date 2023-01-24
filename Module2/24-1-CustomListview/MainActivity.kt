package com.example.listexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list:MutableList<Model>
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list)
        list = ArrayList()

        list.add(Model(R.drawable.pizza,"Pizza","250"))
        list.add(Model(R.drawable.burger,"Burger","70"))
        list.add(Model(R.drawable.coffee,"Coffee","120"))
        list.add(Model(R.drawable.pizza,"Pizza","250"))
        list.add(Model(R.drawable.burger,"Burger","70"))
        list.add(Model(R.drawable.coffee,"Coffee","120"))
        list.add(Model(R.drawable.pizza,"Pizza","250"))
        list.add(Model(R.drawable.burger,"Burger","70"))
        list.add(Model(R.drawable.coffee,"Coffee","120"))

        var adapter = MyAdapter(applicationContext,list)
        listView.adapter=adapter

    }
}