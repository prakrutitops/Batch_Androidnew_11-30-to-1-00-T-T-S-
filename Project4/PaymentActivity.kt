package com.example.test.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.test.R
import com.example.test.databinding.ActivityCategoryBinding
import com.example.test.databinding.ActivityPaymentBinding
import com.squareup.picasso.Picasso

class PaymentActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i = intent
        var id = i.getIntExtra("id",100)
        var name = i.getStringExtra("name")
        var price = i.getStringExtra("price")
        var des = i.getStringExtra("description")
        var img = i.getStringExtra("image")


        binding.categoryNameTextView.setText(name)
        binding.categoryDescTextView.setText(price)
        binding.categoryPriceTextView.setText((des))
        Picasso.get().load(img).into(binding.categoryImageView)

        binding.idBtnMakePaymanet.setOnClickListener {


                Toast.makeText(applicationContext,"Started",Toast.LENGTH_LONG).show()


        }



    }
}