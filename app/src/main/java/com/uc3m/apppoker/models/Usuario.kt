package com.uc3m.apppoker.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuario_table")
data class Usuario(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val nickname: String,
        val password: String,
        val high_card: Int = 0,
        val pair: Int = 0,
        val two_pair: Int = 0,
        val three_kind: Int = 0,
        val straight: Int = 0,
        val flush: Int = 0,
        val full: Int = 0,
        val poker: Int = 0,
        val straight_flush: Int = 0,
        val royal_flush: Int = 0


)




