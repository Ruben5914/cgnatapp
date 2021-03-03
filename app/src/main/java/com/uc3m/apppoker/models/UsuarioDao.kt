package com.uc3m.apppoker.models

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UsuarioDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUsuario(usuario: Usuario)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addHandToUser(hand: Hand)

    @Query("SELECT * FROM user_table ORDER BY id_user ASC")
    fun readAll(): LiveData<List<Usuario>>


    @Query("SELECT * FROM hand_table WHERE id_hand_user=:id_hand_user")
    fun readAllHand(id_hand_user: Int): LiveData<List<Hand>>


}