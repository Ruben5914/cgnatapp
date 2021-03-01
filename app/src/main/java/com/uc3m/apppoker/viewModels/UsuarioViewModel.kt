package com.uc3m.apppoker.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.uc3m.apppoker.models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UsuarioViewModel(application: Application): AndroidViewModel(application) {

    val readAll: LiveData<List<Usuario>>
    private val repository: UsuarioRepository


    init {
        val usuarioDao = UsuarioDataBase.getDatabase(application).UsuarioDao()
        repository = UsuarioRepository(usuarioDao)
        readAll = repository.readAll
    }

    fun addStudent(usuario: Usuario){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUsuario(usuario)
        }
    }



}