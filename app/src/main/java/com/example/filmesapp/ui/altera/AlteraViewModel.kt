package com.example.filmesapp.ui.altera

import androidx.lifecycle.ViewModel

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import com.example.filmesapp.model.Filme
import com.example.filmesapp.repository.AppDatabase

import kotlinx.coroutines.launch

class AlteraViewModel(application: Application, id:Long) : AndroidViewModel(application)  {

    var filme = MutableLiveData<Filme>()

    private var _eventAlteraFilme = MutableLiveData<Boolean>(false)
    val eventAlteraFilme:LiveData<Boolean>
        get() = _eventAlteraFilme




    private val db: AppDatabase by lazy {
        Room.databaseBuilder(
            application.applicationContext,
            AppDatabase::class.java,
            "filme.sqlite")
            .build()
    }

    init {
        viewModelScope.launch {
            filme.value =  db.filmeDAO().listById(id)
        }
    }

    fun onAlteraFilmeStart(){

        viewModelScope.launch {
            db.filmeDAO().editar(filme.value!!)
        }
        _eventAlteraFilme.value = true
    }

    fun onAlteraFilmeCompleto(){
        _eventAlteraFilme.value = false
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