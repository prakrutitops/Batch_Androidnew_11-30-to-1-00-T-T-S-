package com.example.finalproject_batch_1130.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.finalproject_batch_1130.R
import com.example.finalproject_batch_1130.databinding.ActivityCategoryBinding
import com.example.finalproject_batch_1130.databinding.ActivityDashboardBinding

class CategoryActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i = intent
       var pos = i.getIntExtra("pos",111)

        Toast.makeText(applicationContext,""+pos,Toast.LENGTH_LONG).show()


        if(pos==0)
        {

        }
        if(pos==1)
        {

        }


    }
}