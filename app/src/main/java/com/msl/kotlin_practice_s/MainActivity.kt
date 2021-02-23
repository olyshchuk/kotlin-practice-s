package com.msl.kotlin_practice_s

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.msl.kotlin_practice_s.adapter.RickAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recycleView: RecyclerView
    private lateinit var recyclerAdapter: RickAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

    private fun initRecycler() {

        recycleView = findViewById(R.id.recyclerView)
        recycleView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)

            recyclerAdapter = RickAdapter()
            adapter = recyclerAdapter
        }
    }

    private fun initViewModel() {

    }
}