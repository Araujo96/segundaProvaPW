package com.example.filmesapp

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.filmesapp.model.Filme

@BindingAdapter("anoAsText")
fun TextView.setnotaAsText(filme: Filme){
    filme.let { it ->
        text = filme.converterAnoString()
    }
}