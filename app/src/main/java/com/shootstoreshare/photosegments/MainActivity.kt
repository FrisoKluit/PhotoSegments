package com.shootstoreshare.photosegments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager


import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    private lateinit var parentRecyclerView: RecyclerView
    private lateinit var parentAdapter: RecyclerView.Adapter<*>
    var parentModelArrayList: ArrayList<ParentModel> = ArrayList()
    private var parentLayoutManager: RecyclerView.LayoutManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set the Categories for each array list set in the `ParentViewHolder`
        parentModelArrayList.add(ParentModel("Container Loading (0/5)"))
        parentModelArrayList.add(ParentModel("Row 1 (0/2)"))
        parentModelArrayList.add(ParentModel("Row 2 (0/2)"))
        parentModelArrayList.add(ParentModel("Row 3 (0/2)"))
        parentModelArrayList.add(ParentModel("Container Closing (0/3)"))
        parentRecyclerView = findViewById(R.id.Parent_recyclerView)
        parentRecyclerView.setHasFixedSize(true)
        parentLayoutManager = LinearLayoutManager(this)
        parentAdapter = ParentRecyclerViewAdapter(parentModelArrayList, this@MainActivity)
        parentRecyclerView.layoutManager = parentLayoutManager
        parentRecyclerView.adapter = parentAdapter
        parentAdapter.notifyDataSetChanged()

        val fabAdd = findViewById<FloatingActionButton>(R.id.fabAdd)
        fabAdd.setOnClickListener {
            val popupMenu: PopupMenu = PopupMenu(this,it)
            val item1 = popupMenu.menu.add("Container Loading")
            item1.isEnabled = false
            popupMenu.menu.add("Row")
            popupMenu.menu.add("Container Closing")
            popupMenu.show()

            popupMenu.setOnMenuItemClickListener {
                Toast.makeText(this,  it.title, Toast.LENGTH_SHORT).show()
                parentModelArrayList.add(ParentModel("Another one"))
                parentAdapter.notifyItemInserted(parentModelArrayList.count())
                true
            }
        }
    }
}