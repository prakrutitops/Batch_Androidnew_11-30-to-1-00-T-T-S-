package com.example.finalproject_batch_1130.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.finalproject_batch_1130.Client.ApiClient
import com.example.finalproject_batch_1130.Interface.Apiinterface
import com.example.finalproject_batch_1130.databinding.ActivityFullScreenBinding
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FullScreenActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityFullScreenBinding
    lateinit var apiinterface:Apiinterface

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        var i = intent
        var url = i.getStringExtra("pos")
        var txt1 = i.getStringExtra("pos2")
        var txt2 = i.getStringExtra("pos3")
        var txt3 = i.getStringExtra("pos4")

        Picasso.get().load(url).into(binding.photo)
        binding.txtname.setText(txt1)
        binding.txtprice.setText(txt2)
        binding.txtdes.setText(txt3)

        apiinterface= ApiClient.getapiclient()!!.create(Apiinterface::class.java)

        binding.btnwishlist.setOnClickListener {

                var a = binding.txtname.text.toString()
                var  b = binding.txtprice.text.toString()
                var  c = binding.txtdes.text.toString()




            //Toast.makeText(applicationContext," "+a +" "+b+" "+c,Toast.LENGTH_LONG).show()

            var registercall: Call<Void> = apiinterface.wishlistadd("a","b","c",url)

            registercall.enqueue(object: Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {

                   Toast.makeText(applicationContext,"Success ",Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext,"No Internet", Toast.LENGTH_LONG).show()
                }
            })



        }





    }
}