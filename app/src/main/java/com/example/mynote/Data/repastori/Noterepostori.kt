package com.example.mynote.Data.repastori

import com.example.mynote.Data.Db.Note
import com.example.mynote.Data.Db.NoteDao

class Noterepostori (val noteDao: NoteDao) {

    suspend fun getAll(): List<Note>
    {
        return noteDao.getAll()
    }
    suspend fun getFavourite(): List<Note>
    {
        return noteDao.getFavourite()
    }
    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }
    suspend fun update(note: Note) {
        return noteDao.update(note)
    }
    suspend fun delete(note: Note) {
        return noteDao.delete(note)

    }
    suspend fun getNotebyid(id: Int): Note? {
        return noteDao.getNotebyid(id)
    }

}