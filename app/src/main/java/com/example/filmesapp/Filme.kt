package com.example.filmesapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Filme (
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
}

