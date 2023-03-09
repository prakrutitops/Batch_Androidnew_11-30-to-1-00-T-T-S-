package com.example.jsoncrudex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jsoncrudex.databinding.ActivityMain3Binding
import com.example.jsoncrudex.databinding.ActivityMainBinding
import org.json.JSONException

class MainActivity3 : AppCompatActivity()
{
    private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i = intent
       var id = i.getStringExtra("id")
        binding.edtname.setText(i.getStringExtra("name"))
        binding.edtprice.setText(i.getStringExtra("price"))
        binding.edtdes.setText(i.getStringExtra("des"))

        binding.btn1.setOnClickListener {

            var name = binding.edtname.text.toString()
            var price = binding.edtprice.text.toString()
            var des = binding.edtdes.text.toString()

            var stringrequest:StringRequest=object:StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/InventorymanaementSystem/productupdate.php",Response.Listener {
                try
                {

                    Toast.makeText(applicationContext,"UPDATED",Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext,MainActivity2::class.java))

                }
                catch (e:JSONException)
                {
                    println(e)
                }
            },Response.ErrorListener {

                Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()

            })
            {
                override fun getParams(): MutableMap<String, String>?
                {
                    var map = HashMap<String,String>()
                    map.put("product_id",id.toString())
                    map.put("product_name",name)
                    map.put("product_price",price)
                    map.put("product_description",des)
                    return map
                }
            }
            var queue:RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringrequest)

        }

    }
}