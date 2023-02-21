package com.example.islami.ui.home.quran.suraDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islami.R

class VersesAdapter() : RecyclerView.Adapter<VersesAdapter.ViewHolder>() {

    var items: List<String>? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val content: TextView = itemView.findViewById(R.id.verse_text_view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_verse, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val content: String? = items?.get(position)
        holder.content.text = content
    }

    fun changeData(verses: List<String>) {
        this.items = verses
        notifyDataSetChanged()
    }
}