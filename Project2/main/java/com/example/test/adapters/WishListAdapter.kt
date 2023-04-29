package com.example.test

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.squareup.picasso.Picasso

class WishListAdapter(var context: Context, var mutableList: MutableList<WishListModel>) :
    RecyclerView.Adapter<ViewHolder2>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder2
    {
        val view = LayoutInflater.from(context).inflate(R.layout.design_wishlist, parent, false)
        return ViewHolder2(view)
    }

    override fun getItemCount(): Int {
        return mutableList.size
    }

    override fun onBindViewHolder(holder: ViewHolder2, position: Int)
    {
        holder.textView1.text = mutableList[position].gift_name
        holder.textView2.text = mutableList[position].gift_price
        holder.textView3.text = mutableList[position].gift_description
        Picasso.get().load(mutableList.get(position).image).into(holder.imageView)

    }
}

class ViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView)
{
    var textView1 = itemView.findViewById<TextView>(R.id.category_name_textView)
    var textView2 = itemView.findViewById<TextView>(R.id.category_price_textView)
    var textView3 = itemView.findViewById<TextView>(R.id.category_desc_textView)
    var imageView = itemView.findViewById<ImageView>(R.id.category_imageView)

}
