package com.example.app_login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BoletoAdapter (private  val boletos : List<Boleto>) : RecyclerView.Adapter<BoletoAdapter.BoletoViewHolder>(){

    class BoletoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo: TextView = itemView.findViewById(R.id.txtTitulo)
        val valor: TextView = itemView.findViewById(R.id.txtValor)
        val vencimento: TextView = itemView.findViewById(R.id.txtVencimento)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        p1: Int
    ): BoletoAdapter.BoletoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_boleto, parent, false)
        return BoletoViewHolder(view)
    }

    override fun onBindViewHolder(holder: BoletoAdapter.BoletoViewHolder, position: Int) {
        val boleto = boletos[position]
        holder.titulo.text = boleto.titulo
        holder.valor.text = boleto.valor
        holder.vencimento.text = boleto.vencimento
    }

    override fun getItemCount(): Int {
        return boletos.size
    }
}
