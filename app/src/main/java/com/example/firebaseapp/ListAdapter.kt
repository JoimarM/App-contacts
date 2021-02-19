package com.example.firebaseapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private var list: ArrayList<ListElement>) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItems(data: ListElement) {

            val name: TextView = itemView.findViewById(R.id.nameTextView)
            val city: TextView = itemView.findViewById(R.id.cityTextView)
            val status: TextView = itemView.findViewById(R.id.statusTextView)

            //Asignamos los valores
            name.text = data.name
            city.text = data.city
            status.text = data.status


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.list_element, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        holder.bindItems(list[position])

    }

    override fun getItemCount(): Int {
        return list.size
    }


}