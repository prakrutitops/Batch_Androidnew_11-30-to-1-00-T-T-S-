package com.example.sqlitedbex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sqlitedbex.databinding.ActivityUpdateBinding
import com.example.sqlitedbex.databinding.ActivityViewBinding

class UpdateActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityUpdateBinding
    lateinit var dbHelper: DbHelper
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        dbHelper = DbHelper(applicationContext)
        var i = intent
        var id = i.getIntExtra("id",101)
        var name = i.getStringExtra("name")
        var number = i.getStringExtra("number")



        binding.edtname.setText(name)
        binding.edtnum.setText(number)

        binding.btnupdate.setOnClickListener {

                var name = binding.edtname.text.toString()
                var num = binding.edtnum.text.toString()

                    var m = Model()
                     m.id=id
                    m.name=name//set
                    m.num=num//set

                dbHelper.updatedata(m)
            startActivity(Intent(applicationContext,ViewActivity::class.java))

        }



    }
}