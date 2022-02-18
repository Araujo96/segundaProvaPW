package com.example.filmesapp.repository

import androidx.lifecycle.LiveData
import com.example.filmesapp.model.Filme
import kotlinx.coroutines.flow.Flow

class FilmeRepository(private val filmeDAO: FilmeDAO) {

    var List:Flow<List<Filme>> = filmeDAO.buscarTodos()

    suspend fun cadastrar(f:Filme){
        filmeDAO.cadastrar(f)
    }
    suspend fun editar(f: Filme){
        filmeDAO.editar(f)
    }
    suspend fun listById(id:Long):Filme{
        return filmeDAO.listById(id)

    }
    suspend fun update(f: Filme){
        filmeDAO.update(f)
    }
}