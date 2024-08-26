package com.example.mynote.di

import android.content.Context
import androidx.room.Room
import com.example.mynote.Data.Db.NoteDao
import com.example.mynote.Data.Db.NoteDatabse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provid(@ApplicationContext context: Context): NoteDatabse {
        return Room.databaseBuilder(
            context.applicationContext,
            NoteDatabse::class.java,
            "database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteDao(noteDatabse: NoteDatabse): NoteDao {
        return noteDatabse.NoteDoa()

    }
}