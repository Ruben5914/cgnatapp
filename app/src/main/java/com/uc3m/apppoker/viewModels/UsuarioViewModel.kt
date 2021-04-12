package com.uc3m.apppoker.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.uc3m.apppoker.models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import java.security.KeyStore
import javax.crypto.SecretKey


class UsuarioViewModel(application: Application): AndroidViewModel(application) {

    val readAll: LiveData<List<Usuario>>
    private val repository: UsuarioRepository
    val readAllHands: LiveData<List <Hand>>


    init {
        val usuarioDao = UsuarioDataBase.getDatabase(application).UsuarioDao()
        repository = UsuarioRepository(usuarioDao)
        readAll = repository.readAll
        readAllHands = repository.readAllHand
    }

    fun addUsuario(usuario: Usuario){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUsuario(usuario)
        }
    }

    fun addHandToUser(hand: Hand){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addHandToUser(hand)
        }
    }


    fun checkKey(): Boolean {
        val keystore: KeyStore = KeyStore.getInstance("AndroidKeyStore")
        keystore.load(null)


        try {
            val secretKeyEntry: KeyStore.SecretKeyEntry? = keystore?.getEntry("MyKeyStore", null) as KeyStore.SecretKeyEntry
        } catch (e: Exception){
            return false
        }
        return true

          //return secretKeyEntry.secretKey != null
    }



}