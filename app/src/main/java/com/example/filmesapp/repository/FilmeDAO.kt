package com.example.filmesapp.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.filmesapp.model.Filme
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmeDAO {
    @Insert
    suspend fun cadastrar(f: Filme)

    @Update
    suspend fun editar(f: Filme)

    @Delete
    suspend fun excluir(f: Filme)
    @Update
    suspend fun update(f:Filme)

    @Query("SELECT * from Filme")
    fun buscarTodos(): Flow<List<Filme>>

    @Query("SELECT * from filme where id=:id")
    suspend fun listById(id:Long): Filme

    @Query("DELETE FROM Filme")
    fun excluirTodos()

}