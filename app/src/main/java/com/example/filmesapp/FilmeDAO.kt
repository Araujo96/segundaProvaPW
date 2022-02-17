package com.example.filmesapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FilmeDAO {
    @Insert
    suspend fun cadastrar(p:Filme)
    @Update
    suspend fun editar(p:Filme)
    @Delete
    suspend fun excluir(p: Filme)
    @Query("SELECT * from Filme")
    fun buscarTodos():LiveData<List<Filme>>
    @Query("SELECT * from filme where id=:id")
    fun buscarPorId(id:Long): LiveData<Filme>
    @Query("DELETE FROM Filme")
    fun excluirTodos()

}