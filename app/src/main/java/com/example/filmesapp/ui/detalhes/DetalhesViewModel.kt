package com.example.filmesapp.ui.detalhes

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import com.example.filmesapp.model.Filme
import com.example.filmesapp.repository.FilmeDatabase
import kotlinx.coroutines.launch

class DetalhesViewModel(application: Application, id:Long) : AndroidViewModel(application) {

    lateinit var filme: LiveData<Filme>

    private val db: FilmeDatabase by lazy {
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



    class DetalhesFragmentViewModelFactory(val application: Application, val id:Long) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetalhesViewModel::class.java)) {
                return DetalhesViewModel(application, id) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}