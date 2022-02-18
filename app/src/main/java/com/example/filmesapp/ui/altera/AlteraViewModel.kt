package com.example.filmesapp.ui.altera

import androidx.lifecycle.ViewModel

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import com.example.filmesapp.model.Filme
import com.example.filmesapp.repository.AppDatabase
import com.example.filmesapp.repository.FilmeRepository

import kotlinx.coroutines.launch

class AlteraViewModel(val repository: FilmeRepository, id:Long) : ViewModel()  {

    var filme = MutableLiveData<Filme>()

    private var _eventAlteraFilme = MutableLiveData<Boolean>(false)
    val eventAlteraFilme:LiveData<Boolean>
        get() = _eventAlteraFilme


    init {
        viewModelScope.launch {
            filme.value =  repository.listById(id)
        }
    }

    fun onAlteraFilmeStart(){

        viewModelScope.launch {
            repository.editar(filme.value!!)
        }
        _eventAlteraFilme.value = true
    }

    fun onAlteraFilmeCompleto(){
        _eventAlteraFilme.value = false
    }

    class Factory(val repository: FilmeRepository,val id: Long) : ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AlteraViewModel::class.java)) {
                return AlteraViewModel(repository, id) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}