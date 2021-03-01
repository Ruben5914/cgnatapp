package com.uc3m.apppoker.models

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UsuarioDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUsuario(usuario: Usuario)

    @Query("SELECT * FROM usuario_table ORDER BY id ASC")
    fun readAll(): LiveData<List<Usuario>>
}