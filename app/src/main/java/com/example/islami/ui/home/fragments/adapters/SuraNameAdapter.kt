package com.example.islami.ui.home.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class SuraNameAdapter(val items: List<String>, val itemsNumber: List<String>) :
    RecyclerView.Adapter<SuraNameAdapter.ViewHolder>() {


    var onItemClickListener: OnItemClickedListener? = null

    interface OnItemClickedListener {
        fun onItemClick(position: Int, name: String)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.chapter_name)
        val number: TextView = itemView.findViewById(R.id.chapter_number)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_chapter_name, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val suraName = items.get(position)
        val suraNumber = itemsNumber.get(position)
        holder.name.text = suraName
        holder.number.text = suraNumber
        onItemClickListener?.let { clickListener ->
            holder.itemView.setOnClickListener {
                clickListener?.onItemClick(position, suraName)
            }
        }
//        if (onItemClickListener!=null){
//            holder.itemView.setOnClickListener {
//                    onItemClickListener?.onItemClick(position,suraName)
//            }
//        }
    }

}