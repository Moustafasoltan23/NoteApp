package com.example.mynote.Data.Db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import java.net.IDN

@Dao

interface NoteDao {
    @Query("SELECT *FROM NOTE")
    suspend fun getAll(): List<Note>

    @Query("SELECT * FROM NOTE WHERE isFavourite = 1")
    suspend fun getFavourite(): List<Note>

    @Query("SELECT * FROM NOTE WHERE id =:id")
    suspend fun getNotebyid(id: Int): Note?

    @Insert
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)
}