package com.example.islami.ui.home.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islami.databinding.ItemHadethTitleBinding

class HadethTitlesAdapter(val items: List<Hadeth>) :
    RecyclerView.Adapter<HadethTitlesAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemHadethTitleBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHadethTitleBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.hadethTitle.text = items[position].title
    }
}