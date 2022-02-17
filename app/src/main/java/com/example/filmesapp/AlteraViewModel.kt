package com.example.filmesapp

import androidx.lifecycle.ViewModel

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import kotlinx.coroutines.launch

class AlteraViewModel(application: Application, id:Long) : AndroidViewModel(application)  {

    lateinit var filme:LiveData<Filme>

    private val db:FilmeDatabase by lazy {
        Room.databaseBuilder(
            application.applicationContext,
            FilmeDatabase::class.java,
            "filme.sqlite")
            .build()
    }

    init {
        viewModelScope.launch {
            filme =  db.filmeDao().buscarPorId(id)
        }
    }

    fun alteraPessoa(){
        viewModelScope.launch {
            db.filmeDao().editar(filme.value!!)
        }
    }

    class AlteraViewModelFactory(val application: Application,val id: Long) : ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AlteraViewModel::class.java)) {
                return AlteraViewModel(application, id) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}