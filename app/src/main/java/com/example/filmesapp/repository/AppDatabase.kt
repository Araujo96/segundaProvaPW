package com.example.filmesapp.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.filmesapp.model.Filme


@Database(entities = [Filme::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmeDAO(): FilmeDAO

    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDatabase::class.java, "filme.sqlite")
            .fallbackToDestructiveMigration()
            .build()
    }
}