package com.example.filmesapp.ui.cadastro
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.filmesapp.model.Filme
import com.example.filmesapp.repository.AppDatabase

import kotlinx.coroutines.launch

class CadastroViewModel(application: Application) : AndroidViewModel(application) {

    private val _eventCadastrarFilme = MutableLiveData<Boolean>(false)
    val eventCadastrarFilme: LiveData<Boolean>
        get() = _eventCadastrarFilme


    var filme = Filme()

    private val db: AppDatabase by lazy {
        Room.databaseBuilder(
            application.applicationContext,
            AppDatabase::class.java,
            "filme.sqlite")
            .build()
    }

    fun onCadastraFilmeStart(){
        viewModelScope.launch {
            db.filmeDAO().cadastrar(filme)
        }
        _eventCadastrarFilme.value = true
    }
    fun CadastraFilmeComplete(){
        _eventCadastrarFilme.value = false
    }

}