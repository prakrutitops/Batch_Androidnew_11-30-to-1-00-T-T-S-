package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity2 : AppCompatActivity()
{
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var btn3:Button
    lateinit var btn4:Button



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)

        btn1.setOnClickListener {

            // A to A
            var i = Intent(applicationContext,MainActivity::class.java)
            startActivity(i)
        }
        btn2.setOnClickListener {

                var f1 = FirstFragment()//
                var fm:FragmentManager = supportFragmentManager
                var ft:FragmentTransaction = fm.beginTransaction()
                ft.replace(R.id.frmid,f1).commit()

        }
        btn3.setOnClickListener {

        }
        btn4.setOnClickListener {

        }

    }
}