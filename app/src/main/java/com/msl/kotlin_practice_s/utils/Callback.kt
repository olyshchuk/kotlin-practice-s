package com.msl.kotlin_practice_s.utils

import androidx.recyclerview.widget.DiffUtil
import com.msl.kotlin_practice_s.model.Character

class Callback: DiffUtil.ItemCallback<Character>() {

    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.name == newItem.name
                && oldItem.species == newItem.species
    }
}