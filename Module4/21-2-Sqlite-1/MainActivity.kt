package com.example.sqlitedbex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sqlitedbex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        dbHelper = DbHelper(applicationContext)

        binding.btninsert.setOnClickListener {

            var name = binding.edtname.text.toString()
            var num = binding.edtnum.text.toString()

            var m = Model()
            m.name=name//set
            m.num=num//set

           var id = dbHelper.insertdata(m)

            Toast.makeText(applicationContext,"Record Inserted "+id,Toast.LENGTH_LONG).show()
        }

    }
}