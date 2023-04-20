package com.example.final_project_admin_side

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.classprojectadmin.clients.ApiClient
import com.example.classprojectadmin.intefaces.ApiInterface
import com.example.classprojectadmin.models.LoginModel
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var edtPhone: TextInputEditText
    private lateinit var edtPassword: TextInputEditText
    private lateinit var btnLogin: Button
    private lateinit var apiInterface: ApiInterface
    private lateinit var sharedPreferences: SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtPhone = findViewById(R.id.edtPhone)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        apiInterface = ApiClient.getApiClient()!!.create(ApiInterface::class.java)
        sharedPreferences = getSharedPreferences("SESSION", Context.MODE_PRIVATE)
        if (
            sharedPreferences.getBoolean("SESSION", false) &&
            sharedPreferences.getString("phone", "")!!.isNotEmpty()
        ) {
            startActivity(Intent(applicationContext, UploadImageActivity::class.java))
            finish()
        }


        btnLogin.setOnClickListener {
            if (edtPhone.text!!.isEmpty() && edtPassword.text.isNullOrEmpty()) {
                edtPhone.error = "Phone number must not be empty."
                edtPassword.error = "Password must not be empty."
            } else {
                val phone = edtPhone.text.toString()
                val password = edtPassword.text.toString()
                val call: Call<LoginModel> = apiInterface.loginData(phone, password)
                call.enqueue(object : Callback<LoginModel> {
                    override fun onResponse(
                        call: Call<LoginModel>,
                        response: Response<LoginModel>
                    ) {
                        Toast.makeText(applicationContext, "Successfully logged in.", Toast.LENGTH_SHORT).show()
                        sharedPreferences.edit().putString("phone", phone).apply()
                        sharedPreferences.edit().putBoolean("SESSION", true).apply()
                        startActivity(Intent(applicationContext, UploadImageActivity::class.java))
                        finish()
                    }

                    override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                        Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}