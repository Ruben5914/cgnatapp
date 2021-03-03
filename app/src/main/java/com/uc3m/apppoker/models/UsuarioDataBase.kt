package com.uc3m.apppoker.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Usuario::class, Hand::class], version = 1, exportSchema = false)
abstract class UsuarioDataBase: RoomDatabase() {

    abstract fun UsuarioDao(): UsuarioDao

    companion object{

        @Volatile
        private var INSTANCE: UsuarioDataBase? = null

        fun getDatabase(context: Context): UsuarioDataBase{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            UsuarioDataBase::class.java,
                            "user_database"
                    ).allowMainThreadQueries().build()
                }
                return instance
            }
        }

    }

}