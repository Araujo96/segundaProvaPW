package com.example.filmesapp.ui.home

import android.app.Application
import android.view.View
import androidx.lifecycle.*
import androidx.room.Room
import com.example.filmesapp.model.Filme
import com.example.filmesapp.repository.FilmeRepository
import com.example.filmesapp.ui.detalhes.DetalhesViewModel


class HomeViewModel(repository: FilmeRepository) : ViewModel() {
    var list:LiveData<List<Filme>> = repository.List.asLiveData()

    class Factory(val repository: FilmeRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                return HomeViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}