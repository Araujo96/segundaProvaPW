package com.example.filmesapp.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.filmesapp.model.Filme
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmeDAO {
    @Insert
    suspend fun cadastrar(p: Filme)

    @Update
    suspend fun editar(p: Filme)

    @Delete
    suspend fun excluir(p: Filme)

    @Query("SELECT * from Filme")
    fun buscarTodos(): Flow<List<Filme>>

    @Query("SELECT * from filme where id=:id")
    suspend fun listById(id:Long): Filme

    @Query("DELETE FROM Filme")
    fun excluirTodos()

}