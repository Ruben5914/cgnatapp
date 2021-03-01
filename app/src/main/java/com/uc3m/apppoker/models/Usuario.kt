package com.uc3m.apppoker.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuario_table")
data class Usuario(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val nickname: String,
        val password: String,
        val high_card: Int,
        val pair: Int,
        val two_pair: Int,
        val three_kind: Int,
        val straight: Int,
        val flush: Int,
        val full: Int,
        val poker: Int,
        val straight_flush: Int,
        val royal_flush: Int


)




