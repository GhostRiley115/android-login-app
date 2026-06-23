package com.example.mobile_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReservaAdapter (private val reservas : List<Reserva>) :  RecyclerView.Adapter<ReservaAdapter.ReservaViewHolder>(){

    class ReservaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo : TextView = itemView.findViewById(R.id.txtTitulo)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        p1: Int
    ): ReservaAdapter.ReservaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_reserva, parent, false)
        return ReservaViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReservaAdapter.ReservaViewHolder, position: Int) {
        val reserva = reservas[position]
        holder.titulo.text = reserva.titulo
    }

    override fun getItemCount(): Int {
        return reservas.size
    }
}