package com.example.finalproject_batch_1130.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import com.example.finalproject_batch_1130.Client.ApiClient
import com.example.finalproject_batch_1130.Interface.Apiinterface
import com.example.finalproject_batch_1130.R
import com.example.finalproject_batch_1130.databinding.ActivitySignupBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: ActivitySignupBinding
    lateinit var apiinterface: Apiinterface
     var gender1=""
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnsignup.setOnClickListener {

            var fname = binding.edtFirstName.text.toString()
            var lname = binding.edtLastName.text.toString()
            var email = binding.edtEmail.text.toString()
            var phone = binding.edtPhone.text.toString()
            var pass= binding.edtPassword.text.toString()

            binding.rbMale.setOnCheckedChangeListener(this)
            binding.rbFemale.setOnCheckedChangeListener(this)



            if(pass.length==0)
            {
                Toast.makeText(applicationContext,"Please Enter Proper Password",Toast.LENGTH_LONG).show()
            }
            else
            {
                if(fname.length==0 )
                {
                    binding.edtFirstName.setError("Please Enter Proper FirstName")
                }
                else if(lname.length==0 )
                {
                    binding.edtLastName.setError("Please Enter Proper LastName")
                }
                else if(email.length==0 )
                {
                    binding.edtEmail.setError("Please Enter Proper Email")
                }
                else if(phone.length!=10 )
                {
                    binding.edtPhone.setError("Please Enter Proper Phone Number")
                }
                else
                {
                    apiinterface= ApiClient.getapiclient()!!.create(Apiinterface::class.java)
                    var registercall: Call<Void> = apiinterface.registerdetail(fname,lname,gender1,email,phone,pass)
                    registercall.enqueue(object: Callback<Void> {
                        override fun onResponse(call: Call<Void>, response: Response<Void>) {

                            startActivity(Intent(applicationContext, LoginActivity::class.java))
                        }

                        override fun onFailure(call: Call<Void>, t: Throwable) {
                            Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
                        }
                    })


                }



            }




        }

        binding.textView3.setOnClickListener {
            startActivity(Intent(applicationContext, LoginActivity::class.java))


        }




    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean)
    {
        if(binding.rbMale.isChecked)
        {
            gender1="Male"
        }
        if(binding.rbFemale.isChecked)
        {
            gender1="Female"
        }
    }
}