package com.example.filmesapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room


class HomeViewModel(application: Application) : AndroidViewModel(application) {
    var list:LiveData<List<Filme>>

    private val db:FilmeDatabase by lazy {
        Room.databaseBuilder(
            application.applicationContext,
            FilmeDatabase::class.java,
            "filme.sqlite")
            .build()
    }

    init {
        list = db.filmeDao().buscarTodos()
    }
}