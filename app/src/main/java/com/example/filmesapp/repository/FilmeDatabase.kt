package com.example.filmesapp.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.filmesapp.model.Filme


@Database(entities = [Filme::class], version = 1)
abstract class FilmeDatabase:RoomDatabase() {
    abstract fun filmeDao(): FilmeDAO
}