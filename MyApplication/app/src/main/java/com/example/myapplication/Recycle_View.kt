package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R.drawable
import com.example.myapplication.adapter.RecyclerAdapter

class Recycle_View : AppCompatActivity() {
    lateinit var recycleView: RecyclerView
    var titleList = ArrayList<String>()
    var imageList = ArrayList<Int>()
    var descList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle_view)

        recycleView = findViewById(R.id.recyclerView)

        titleList.add("Apple")
        titleList.add("Banana")
        titleList.add("Grapes")
//        imageList.add(R.drawable.apple)
//        imageList.add(R.drawable.apple)
//        imageList.add(R.drawable.apple)
        descList.add("This is apple....")
        descList.add("This is apple....")
        descList.add("This is apple....")

        var adapter = RecyclerAdapter(titleList, imageList, descList)
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = adapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }
}
