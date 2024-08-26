package com.example.mynote.Data.Db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabse : RoomDatabase() {

    abstract fun NoteDoa(): NoteDao


    companion object {
        @Volatile
        private var INSTANCE: NoteDatabse? = null

        fun getDatabase(context: Context): NoteDatabse {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabse::class.java,
                    "database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
