package com.example.filmesapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Filme (
    var nome: String,
    var pais: String,
    var classificacao: String,
    var diretor: String,
    var nota: Int,
    var ano: Int
){
    @PrimaryKey(autoGenerate = true)
    var id = 0L
    constructor():this("","","","",0,0)
    fun converterAnoString():String{
        return ano.toString()

    }
}

