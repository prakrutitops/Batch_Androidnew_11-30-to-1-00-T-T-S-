package com.tops.checkboxandradiobuttonex

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AlertDialog

class MainActivity2 : AppCompatActivity()
{
    lateinit var chk1:CheckBox
    lateinit var chk2:CheckBox
    lateinit var chk3:CheckBox
    lateinit var btn1:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        chk1 = findViewById(R.id.chk1)
        chk2 = findViewById(R.id.chk2)
        chk3 = findViewById(R.id.chk3)
        btn1 = findViewById(R.id.btn1)

        btn1.setOnClickListener {

            var amount =0
            var builder =StringBuilder("\n Selected Items ")

            if(chk1.isChecked)
            {
                amount+=100
                builder.append("\n Pizza @ Rs. 100 ")
            }
            if(chk2.isChecked)
            {
                amount+=70
                builder.append("\n Burger @ Rs. 70 ")
            }
            if(chk3.isChecked)
            {
                amount+=120
                builder.append("\n Coffee @ Rs. 120 ")
            }

            builder.append("\n Total: "+amount)

            var i = Intent(applicationContext,BillActivity::class.java)
            i.putExtra("Bill",builder.toString())
            startActivity(i)

        }


    }

    override fun onBackPressed() {

        var alert = AlertDialog.Builder(this)
        alert.setTitle("Are you sure you want to exit?")
        alert.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int -> finishAffinity()})
        alert.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int -> dialogInterface.cancel() })
        alert.show()



    }
}