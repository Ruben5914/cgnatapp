package com.uc3m.apppoker.models

import androidx.lifecycle.LiveData

class UsuarioRepository(private val usuarioDao: UsuarioDao) {

    val readAll: LiveData<List<Usuario>> = usuarioDao.readAll()
    val readAllHand: LiveData<List<Hand>> = usuarioDao.readAllHand(0)

    suspend fun addUsuario(usuario: Usuario){
        usuarioDao.addUsuario(usuario)
    }

    suspend fun addHandToUser(hand: Hand){
        usuarioDao.addHandToUser(hand)
    }

}