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

class DashboardAdapter(var context: Context, var mutableList: MutableList<DashboardModel>) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.dashboard_design, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mutableList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = mutableList[position].name
        Picasso.get().load(mutableList.get(position).url).into(holder.imageView)
        holder.itemView.setOnClickListener {
            var i = Intent(context, CategoryActivity::class.java)
            i.putExtra("position", position)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var textView = itemView.findViewById<TextView>(R.id.dashboard_txt)
    var imageView = itemView.findViewById<ImageView>(R.id.dashboard_img)
}
