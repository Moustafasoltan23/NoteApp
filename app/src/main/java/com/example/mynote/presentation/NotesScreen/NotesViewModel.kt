package com.example.mynote.presentation.NotesScreen



import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynote.Data.Db.Note
import com.example.mynote.Data.Db.NoteDatabse
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class oteViewModel(application: Application): AndroidViewModel(application) {


    private val noteDao = NoteDatabse.getDatabase(application).NoteDoa()

    private val _allNotes = MutableStateFlow<List<Note>?>(null)
    val allNotes : StateFlow<List<Note>?> get() = _allNotes

    private val _allFavouriteNotes= MutableStateFlow<List<Note>?>(null)
    val allFavouriteNotes : StateFlow<List<Note>?> get() = _allFavouriteNotes







    init {
        getAllNotes()
        getAllFavouriteNotes()
    }


    fun getAllFavouriteNotes() {
        viewModelScope.launch {
            _allFavouriteNotes.value = noteDao.getFavourite()
            println("All notes: ${_allFavouriteNotes.value}")
        }
    }

    fun getAllNotes() {
        viewModelScope.launch {
            _allNotes.value = noteDao.getAll()
            println("All notes: ${_allNotes.value}")
        }
    }


    fun updateNotes(note: Note){
        viewModelScope.launch {
            noteDao.update(note)
            getAllNotes()
        }
    }
    fun deleteNotes(note: Note){
        viewModelScope.launch {
            noteDao.delete(note)
            getAllNotes()
        }
    }
    fun Favouritenotes(note: Note){
        viewModelScope.launch {
            noteDao.getFavourite()
            getAllNotes()
        }
    }
}