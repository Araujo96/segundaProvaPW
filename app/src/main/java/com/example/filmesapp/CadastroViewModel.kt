package com.example.filmesapp
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.launch

class CadastroViewModel(application: Application) : AndroidViewModel(application) {

    var filme = Filme()

    private val db:FilmeDatabase by lazy {
        Room.databaseBuilder(
            application.applicationContext,
            FilmeDatabase::class.java,
            "filme.sqlite")
            .build()
    }

    fun cadastraPessoa(){
        viewModelScope.launch {
            db.filmeDao().cadastrar(filme)
        }
    }
}