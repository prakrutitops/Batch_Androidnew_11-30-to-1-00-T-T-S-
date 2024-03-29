package com.example.finalproject_batch_1130.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.finalproject_batch_1130.Client.ApiClient
import com.example.finalproject_batch_1130.Interface.Apiinterface
import com.example.finalproject_batch_1130.Model.RegisterModel
import com.example.finalproject_batch_1130.R
import com.example.finalproject_batch_1130.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity()
{

    private lateinit var binding: ActivityLoginBinding
    lateinit var apiinterface: Apiinterface
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences=getSharedPreferences("user_session", Context.MODE_PRIVATE)


        if (sharedPreferences.getBoolean("user_session", false) && !sharedPreferences.getString("mob", "")!!.isEmpty())
        {
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        }

        binding.btnLogIn.setOnClickListener {


            var phone = binding.edtEmail.text.toString()
            var pass = binding.edtPassword.text.toString()

            apiinterface= ApiClient.getapiclient()!!.create(Apiinterface::class.java)
            var call: Call<RegisterModel> = apiinterface.logindata(phone,pass)
            call.enqueue(object: Callback<RegisterModel> {
                override fun onResponse(
                    call: Call<RegisterModel>,
                    response: Response<RegisterModel>, )
                {
                    sharedPreferences.edit().putString("mob",phone).commit()

                    sharedPreferences.edit().putBoolean("user_session",true).commit()
                    Toast.makeText(applicationContext,"Success", Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext, DashboardActivity::class.java))

                }

                override fun onFailure(call: Call<RegisterModel>, t: Throwable)
                {
                    Toast.makeText(applicationContext,"Fail", Toast.LENGTH_LONG).show()

                }
            })
        }
        binding.textView3.setOnClickListener {

            startActivity(Intent(applicationContext,SignupActivity::class.java))

        }

    }

    override fun onBackPressed() {
        finishAffinity()
    }
}