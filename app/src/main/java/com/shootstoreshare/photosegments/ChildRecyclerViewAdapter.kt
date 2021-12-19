package com.shootstoreshare.photosegments

import android.content.Context

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.ImageView

import android.widget.TextView
import android.widget.Toast

import androidx.recyclerview.widget.RecyclerView


class ChildRecyclerViewAdapter(arrayList: ArrayList<ChildModel>, mContext: Context) :
    RecyclerView.Adapter<ChildRecyclerViewAdapter.MyViewHolder>() {
    var childModelArrayList: ArrayList<ChildModel>
    var cxt: Context

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var heroImage: ImageView
        var movieName: TextView

        init {
            heroImage = itemView.findViewById(R.id.hero_image)
            movieName = itemView.findViewById(R.id.movie_name)
            itemView.setOnClickListener {
                Toast.makeText(it.context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.child_recyclerview_items, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = childModelArrayList[position]
        holder.heroImage.setImageResource(currentItem.heroImage)
        holder.movieName.text = currentItem.movieName
    }

    override fun getItemCount(): Int {
        return childModelArrayList.size
    }

    init {
        cxt = mContext
        childModelArrayList = arrayList
    }
}