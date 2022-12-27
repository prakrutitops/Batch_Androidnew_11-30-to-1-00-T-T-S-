package com.tops.FirstApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity()
{

    //declaration
    lateinit var txt1:TextView
    lateinit var txt2:TextView
    lateinit var txt3:TextView
    lateinit var img1:ImageView
    lateinit var btn1:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialization
        txt1 = findViewById(R.id.t1)
        txt2 = findViewById(R.id.t2)
        txt3 = findViewById(R.id.t3)
        img1 = findViewById(R.id.img)
        btn1 = findViewById(R.id.btn1)

        btn1.setOnClickListener {

            Toast.makeText(applicationContext,"Welcome To Tops",Toast.LENGTH_LONG).show()

            var i = Intent(applicationContext,MainActivity2::class.java)
            startActivity(i)
        }



    }
}