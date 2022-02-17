package com.example.filmesapp

import androidx.lifecycle.ViewModel

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import kotlinx.coroutines.launch

class AlteraViewModel(application: Application, id:Long) : AndroidViewModel(application)  {

    lateinit var filme:LiveData<Filme>
    private var _eventAlteraFilme = MutableLiveData<Boolean>(false)
    val eventAlteraFilme:LiveData<Boolean>
        get() = _eventAlteraFilme




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

    fun onAlteraFilmeStart(){

        viewModelScope.launch {
            db.filmeDao().editar(filme.value!!)
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