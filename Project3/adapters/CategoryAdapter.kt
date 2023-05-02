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

class CategoryAdapter(var context: Context, var mutableList: MutableList<CategoryModel>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.category_adapter_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mutableList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Picasso.get().load(mutableList.get(position).image).into(holder.imageView)
        holder.textView1.text = mutableList[position].gift_name
        holder.textView2.text = mutableList[position].gift_price
        holder.textView3.text = mutableList[position].gift_description

        holder.itemView.setOnClickListener {
            var intent = Intent(context, CategoryAdapterItemClickActivity::class.java)
            intent.putExtra("image", mutableList[position].image)
            intent.putExtra("name", mutableList[position].gift_name)
            intent.putExtra("desc", mutableList[position].gift_description)
            intent.putExtra("price", mutableList[position].gift_price)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val imageView: ImageView = itemView.findViewById(R.id.category_imageView)
    val textView1: TextView = itemView.findViewById(R.id.category_name_textView)
    val textView2: TextView = itemView.findViewById(R.id.category_price_textView)
    val textView3: TextView = itemView.findViewById(R.id.category_desc_textView)
}
