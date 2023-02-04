package com.example.sliderlayoutex

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context: Context,var list:MutableList<Model>) : RecyclerView.Adapter<ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var layout = LayoutInflater.from(context)
        var view = layout.inflate(R.layout.design,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.image.setImageResource(list.get(position).image)
        holder.price.setText(list.get(position).price)


    }

    override fun getItemCount(): Int {
        return list.size
    }

}
class ViewHolder(itemview: View) :RecyclerView.ViewHolder(itemview)
{

    var image:ImageView
    var price:TextView

    init
    {
            image = itemview.findViewById(R.id.txt1)
            price = itemview.findViewById(R.id.txt2)
    }

}