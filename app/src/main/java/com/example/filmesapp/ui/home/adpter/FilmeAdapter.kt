package com.example.filmesapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.example.filmesapp.databinding.FilmeLayoutBinding
import com.example.filmesapp.model.Filme


class FilmeAdapter: ListAdapter<Filme,FilmeAdapter.FilmeViewHolder>(FilmeDiffcallBack()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {
        return  FilmeViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
        val filme = currentList[position]
        holder.bind(filme)

    }

    class FilmeViewHolder private constructor(var binding: FilmeLayoutBinding) :RecyclerView.ViewHolder(binding.root){


        fun bind(filme: Filme) {
            binding.filme = filme

        }

        companion object {
             fun from(parent: ViewGroup): FilmeViewHolder {

                 val binding:FilmeLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.filme_layout, parent, false)


                 return FilmeViewHolder(binding)



            }
        }
    }
}
class FilmeDiffcallBack : DiffUtil.ItemCallback<Filme>(){
    override fun areItemsTheSame(oldItem: Filme, newItem: Filme): Boolean {
        return oldItem.id == newItem.id
    }


    override fun areContentsTheSame(oldItem: Filme, newItem: Filme): Boolean {
        return oldItem == newItem
    }

}
