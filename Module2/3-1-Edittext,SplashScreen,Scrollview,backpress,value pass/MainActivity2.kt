package com.tops.formex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity2 : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        var i =intent
       Toast.makeText(applicationContext,"welcome "+ i.getStringExtra("n1"),Toast.LENGTH_LONG).show()


    }

    override fun onBackPressed()
    {
        //super.onBackPressed()
        finishAffinity()
    }
}