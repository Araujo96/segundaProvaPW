package com.example.filmesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FilmeAdapter: RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder>() {

    var list:List<Filme> = ArrayList<Filme>()



    class FilmeViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var nomeTextView = itemView.findViewById<TextView>(R.id.nome)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.filme_layout,parent,false)
        return  FilmeViewHolder(view)
    }


    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
        val filme = list[position]
        holder.nomeTextView.text = filme.nome
    }


    override fun getItemCount(): Int {
        return list.size
    }
}