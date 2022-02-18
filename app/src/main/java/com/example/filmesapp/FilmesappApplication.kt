package com.example.filmesapp

import android.app.Application
import com.example.filmesapp.repository.AppDatabase
import com.example.filmesapp.repository.FilmeRepository

class FilmesappApplication: Application() {


    val database by lazy { AppDatabase.invoke(this) }
    val filmeRepository by lazy { FilmeRepository(database.filmeDAO()) }
}
