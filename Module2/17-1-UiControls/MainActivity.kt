package com.example.uicontrolsex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AbsSpinner
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var spinner: Spinner
    var city = arrayOf("Rajkot","Surat","Baroda")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner= findViewById(R.id.spin)

        var adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,city)
        spinner.adapter=adapter


        spinner.setOnItemSelectedListener(this)




    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        Toast.makeText(applicationContext,"Selected City is : "+city[position],Toast.LENGTH_LONG).show()

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}