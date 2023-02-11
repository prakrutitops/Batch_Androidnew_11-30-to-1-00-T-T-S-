package com.example.sharedprefrenceex

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class DashboardActivity : AppCompatActivity()
{
    lateinit var sharedPreferences: SharedPreferences
    lateinit var btn1:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences = getSharedPreferences("SESSION", Context.MODE_PRIVATE)
        btn1 = findViewById(R.id.btn1)

        Toast.makeText(applicationContext,"Welcome "+sharedPreferences.getString("Name","DEFAULT_NAME"),Toast.LENGTH_LONG).show()

        btn1.setOnClickListener {

            sharedPreferences.edit().clear().commit()
            var i = Intent(applicationContext,MainActivity::class.java)
            startActivity(i)
        }
    }
}