package com.example.filmesapp

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Filme::class], version = 1)
abstract class FilmeDatabase:RoomDatabase() {
    abstract fun filmeDao():FilmeDAO
}