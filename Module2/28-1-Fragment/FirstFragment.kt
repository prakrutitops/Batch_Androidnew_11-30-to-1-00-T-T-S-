package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager


class FirstFragment : Fragment()
{
    lateinit var txt1:TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_first, container, false)

        txt1 = view.findViewById(R.id.txt1)

        txt1.setOnClickListener {

           /* var i = Intent(activity,MainActivity::class.java)
            startActivity(i)*/

            var s1 = SecondFragment()
            var fm:FragmentManager = requireFragmentManager()
            var ft = fm.beginTransaction()
            ft.replace(R.id.frmid,s1).commit()
        }

        return view
    }


}