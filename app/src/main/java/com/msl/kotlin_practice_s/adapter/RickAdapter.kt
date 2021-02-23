package com.msl.kotlin_practice_s.adapter

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.msl.kotlin_practice_s.R
import com.msl.kotlin_practice_s.model.Character
import com.msl.kotlin_practice_s.utils.Callback

class RickAdapter: PagedListAdapter<Character, RickAdapter.MyViewHolder>(Callback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)

        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val title: TextView = view.findViewById(R.id.title)
        val desc: TextView = view.findViewById(R.id.desc)
        val image: ImageView = view.findViewById(R.id.image)

        fun bind(data: Character) {
            title.text = data.name
            if (!TextUtils.isEmpty(data.species)) {
                desc.text = data.species
            } else {
                desc.text = "No species available."
            }

            val url = data.image
            Glide.with(image)
                .load(url)
                .circleCrop()
                .into(image)
        }

    }
}