package com.tops.checkboxandradiobuttonex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class BillActivity : AppCompatActivity()
{
    lateinit var txt1:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill)

        txt1 = findViewById(R.id.txt1)

        var i =intent


        txt1.setText(i.getStringExtra("Bill"))

    }

    override fun onBackPressed() {
        finishAffinity()
    }
}