package com.msl.kotlin_practice_s

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.msl.kotlin_practice_s.adapter.RickAdapter
import com.msl.kotlin_practice_s.viewmodel.RickViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RickAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        initRecyclerView()
        initViewModel()

    }

    private fun initRecyclerView() {

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)

            recyclerAdapter = RickAdapter()
            adapter = recyclerAdapter
        }
    }

    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(RickViewModel::class.java)
        viewModel.getRecyclerListDataObserver()?.observe(this, {

            if(it != null) {
                recyclerAdapter.submitList(it)

            } else {
                Toast.makeText(this@MainActivity, "Error in getting data from api.", Toast.LENGTH_LONG).show()
            }
        })
    }
}