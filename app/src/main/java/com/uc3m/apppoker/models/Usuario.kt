package com.uc3m.apppoker.models


import androidx.room.*


@Entity(tableName = "user_table")
data class Usuario(

        @PrimaryKey(autoGenerate = true)
        val id_user: Int,
        var nickname: String,



)

