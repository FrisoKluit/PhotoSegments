package com.shootstoreshare.photosegments

import android.content.Context

import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup

import android.widget.TextView


class ParentRecyclerViewAdapter(
    private val parentModelArrayList: ArrayList<ParentModel>,
    context: Context
) :
    RecyclerView.Adapter<ParentRecyclerViewAdapter.MyViewHolder>() {
    var cxt: Context

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var category: TextView = itemView.findViewById(R.id.Movie_category)
        var childRecyclerView: RecyclerView = itemView.findViewById(R.id.Child_RV)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.parent_recyclerview_items, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return parentModelArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = parentModelArrayList[position]
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(cxt, LinearLayoutManager.HORIZONTAL, false)
        holder.childRecyclerView.layoutManager = layoutManager
        holder.childRecyclerView.setHasFixedSize(true)
        holder.category.text = currentItem.movieCategory

        val arrayList: ArrayList<ChildModel> = ArrayList()

        // added the first child row
        if (position == 0) {
            arrayList.add(ChildModel(R.drawable.noimage, "Floor 1"))
            arrayList.add(ChildModel(R.drawable.noimage, "Floor 2"))
            arrayList.add(ChildModel(R.drawable.noimage, "Left side"))
            arrayList.add(ChildModel(R.drawable.noimage, "Right side"))
            arrayList.add(ChildModel(R.drawable.noimage, "Container ID"))
        }

        // added in second child row
        if (position == 1) {
            arrayList.add(ChildModel(R.drawable.noimage, "Left"))
            arrayList.add(ChildModel(R.drawable.noimage, "Right"))
        }

        if (position == 2) {
            arrayList.add(ChildModel(R.drawable.noimage, "Left"))
            arrayList.add(ChildModel(R.drawable.noimage, "Right"))
        }

        if (position == 3) {
            arrayList.add(ChildModel(R.drawable.noimage, "Left"))
            arrayList.add(ChildModel(R.drawable.noimage, "Right"))
        }

        if (position == 4) {
            arrayList.add(ChildModel(R.drawable.noimage, "Door closed"))
            arrayList.add(ChildModel(R.drawable.noimage, "Container ID"))
            arrayList.add(ChildModel(R.drawable.noimage, "Seal detail"))
        }

        if (position == 5) {
            arrayList.add(ChildModel(R.drawable.noimage, "Door closed"))
            arrayList.add(ChildModel(R.drawable.noimage, "Container ID"))
            arrayList.add(ChildModel(R.drawable.noimage, "Seal detail"))
        }

        if (position == 6) {
            arrayList.add(ChildModel(R.drawable.noimage, "Door closed"))
            arrayList.add(ChildModel(R.drawable.noimage, "Container ID"))
            arrayList.add(ChildModel(R.drawable.noimage, "Seal detail"))
        }

        val childRecyclerViewAdapter =
            ChildRecyclerViewAdapter(arrayList, holder.childRecyclerView.context)
        holder.childRecyclerView.adapter = childRecyclerViewAdapter

    }

    init {
        cxt = context
    }
}