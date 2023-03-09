package com.example.jsoncrudex

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyAdapter(var context:Context,var list: MutableList<Model>) :BaseAdapter()
{
    override fun getCount(): Int
    {
        return list.size
    }

    override fun getItem(position: Int): Any
    {
       return list.get(position)
    }

    override fun getItemId(position: Int): Long
    {
        return position.toLong()
    }

    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View
    {
        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.design,parent,false)

        var txt1:TextView = view.findViewById(R.id.txt1)
        var txt2:TextView = view.findViewById(R.id.txt2)
        var txt3:TextView = view.findViewById(R.id.txt3)

        txt1.setText(list.get(position).product_name)
        txt2.setText(list.get(position).product_price)
        txt3.setText(list.get(position).product_des)

        return view
    }
}