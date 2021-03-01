package com.uc3m.apppoker.models

import androidx.lifecycle.LiveData

class UsuarioRepository(private val usuarioDao: UsuarioDao) {

    val readAll: LiveData<List<Usuario>> = usuarioDao.readAll()

    suspend fun addUsuario(usuario: Usuario){
        usuarioDao.addUsuario(usuario)
    }
}