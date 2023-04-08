package com.example.retrofitcrudex

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateActivity : AppCompatActivity()
{
    lateinit var edt1: EditText
    lateinit var edt2:EditText
    lateinit var btn1: Button
    lateinit var apiinterface: Apiinterface


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btnupdate)


        apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)

        var i = intent
        var id = i.getIntExtra("id",101)
        var name = i.getStringExtra("name")
        var price = i.getStringExtra("price")

        edt1.setText(name)
        edt2.setText(price)

        btn1.setOnClickListener {

            var pname = edt1.text.toString()
            var pprice = edt2.text.toString()

            var call: Call<Void> = apiinterface.updatedata(id.toString(),pname,pprice)

            call.enqueue(object :Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>)
                {
                    Toast.makeText(applicationContext, "Product Updated", Toast.LENGTH_SHORT).show()
                    val i = Intent(applicationContext, MainActivity2::class.java)
                    startActivity(i)
                }

                override fun onFailure(call: Call<Void>, t: Throwable)
                {
                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show();
                }
            })

        }


    }
}