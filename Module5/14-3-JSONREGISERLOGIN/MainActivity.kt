package com.example.registerloginex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


import com.example.registerloginex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnsignup.setOnClickListener {

                var fname = binding.edtfname.text.toString()
                var lname = binding.edtlname.text.toString()
                var email = binding.edtemail.text.toString()
                var phone = binding.edtphn.text.toString()
                var pass = binding.edtpass.text.toString()


            var stringrequest: StringRequest = object :StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/Greetings123/signup.php",Response.Listener {

                        Toast.makeText(applicationContext,"Registration Done",Toast.LENGTH_LONG).show()
                        startActivity(Intent(applicationContext,LoginActivity::class.java))

            },
            {
                Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
            })
            {
                override fun getParams(): MutableMap<String, String>?
                {
                    var map = HashMap<String,String>()
                    map.put("firstname",fname)
                    map.put("lastname",lname)
                    map.put("email",email)
                    map.put("phone",phone)
                    map.put("password",pass)
                    return map
                }
            }
            var queue: RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringrequest)


        }
    }
}