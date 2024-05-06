package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class RecyclerAdapter (
    var titleList: ArrayList<String>,
    var imageList: ArrayList<Int>,
    var descriptionList: ArrayList<String>
):RecyclerView.Adapter<RecyclerAdapter.FruitsViewHolder>() {

    class FruitsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.textViewTitle)
        var description: TextView = view.findViewById(R.id.textViewDesp)
        var images: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FruitsViewHolder{
        var view : View = LayoutInflater.from(parent.context).inflate(R.layout.sample_resource,parent,false)

        return FruitsViewHolder(view)
    }

    override fun onBindViewHolder(holder: FruitsViewHolder, position: Int) {
        holder.title.text = titleList[position]
        holder.description.text = descriptionList[position]
        holder.images.setImageResource(imageList[position])
    }

    override fun getItemCount(): Int {
        return titleList.size
    }

}