package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity()
{
    lateinit var toolbar:Toolbar
    lateinit var tablayout:TabLayout
    lateinit var viewPager: ViewPager

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.tool)
        setSupportActionBar(toolbar)

        toolbar.setLogo(R.drawable.logo)
        toolbar.setSubtitle("Last Seen")
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)

        viewPager = findViewById(R.id.view)
        setupviewpager()

        tablayout = findViewById(R.id.tab)
        tablayout.setupWithViewPager(viewPager)


        var myAdapter = MyAdapter(supportFragmentManager)
        myAdapter.adddata(ChatFragment(),"CHAT")
        myAdapter.adddata(StatusFragment(),"STATUS")
        myAdapter.adddata(CallFragment(),"CALL")
        viewPager.adapter=myAdapter


        toolbar.setNavigationOnClickListener {

            Toast.makeText(applicationContext,"back button pressed",Toast.LENGTH_LONG).show()

        }


    }

    private fun setupviewpager()
    {

    }
}