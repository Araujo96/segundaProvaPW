package com.example.filmesapp.ui.detalhes

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import com.example.filmesapp.model.Filme
import com.example.filmesapp.repository.AppDatabase
import com.example.filmesapp.repository.FilmeRepository

import kotlinx.coroutines.launch

class DetalhesViewModel(repository: FilmeRepository, id: Long) : ViewModel() {

     var filme = MutableLiveData<Filme>()


    init {
        viewModelScope.launch {
            filme.value =  repository.listById(id)
        }
    }



    class Factory(val repository: FilmeRepository, val id:Long) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetalhesViewModel::class.java)) {
                return DetalhesViewModel(repository, id) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}