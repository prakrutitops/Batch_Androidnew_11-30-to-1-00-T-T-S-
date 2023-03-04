package com.example.jsonparsing

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

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
        var layout = LayoutInflater.from(context)
        var view = layout.inflate(R.layout.design,parent,false)

        var txt1:TextView = view.findViewById(R.id.txt1)
        var txt2:TextView = view.findViewById(R.id.txt2)
        var image:ImageView = view.findViewById(R.id.image)

        txt1.setText(list.get(position).product_name)
        txt2.setText(list.get(position).product_price)
        Picasso.get().load(list.get(position).product_image).into(image)

        return view
    }

}