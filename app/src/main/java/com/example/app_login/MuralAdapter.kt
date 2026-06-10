package com.example.app_login

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MuralAdapter (private val murais : List<Mural>) : RecyclerView.Adapter<MuralAdapter.MuralViewHolder>(){

    class MuralViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo : TextView = itemView.findViewById(R.id.txtTitulo)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        p1: Int
    ): MuralAdapter.MuralViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mural,parent,false)
        return MuralViewHolder(view)
    }

    override fun onBindViewHolder(holder: MuralAdapter.MuralViewHolder, position: Int) {
        val mural = murais[position]
        holder.titulo.text = mural.titulo
    }

    override fun getItemCount(): Int {
        return murais.size
    }
}