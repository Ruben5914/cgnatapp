package com.uc3m.apppoker.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
@Entity(indices =  arrayOf(Index(value = [ "id_hand_user"])),tableName = "hand_table", foreignKeys = [ForeignKey(entity = Usuario::class,
        parentColumns = ["id_user"], childColumns = ["id_hand_user"], onDelete = ForeignKey.CASCADE)])

data class Hand (



            @PrimaryKey(autoGenerate = true)
            var id_hand: Int,
            var id_hand_user: Int,
            var hand: String


)