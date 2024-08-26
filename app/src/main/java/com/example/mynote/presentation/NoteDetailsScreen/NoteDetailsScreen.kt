package com.example.mynote.presentation.NoteDetailsScreen

import android.app.Application
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.mynote.Data.Db.Note
import com.example.mynote.ui.noteViewModel

class NoteDetailsScreen( val note: Note) :Screen {
    @Composable
    override fun Content() {
        val noteViewModel = NoteDetailsViewModel(LocalContext.current.applicationContext as Application)
        val title = remember { mutableStateOf(note.title) }
        val decsription = remember { mutableStateOf(note.description) }
        val  navigtor = LocalNavigator.currentOrThrow
        Column(modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally , verticalArrangement = Arrangement.Center) {
            IconButton(onClick = { navigtor.pop() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription =null )
                
            }
            OutlinedTextField(value =title.value , onValueChange ={title.value= it} )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value =decsription.value , onValueChange ={decsription.value = it} )
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Button(onClick = { noteViewModel.updateNotes(note.copy(title = title.value , description = decsription.value))}) {
                    Text(text = "Update Note")

                }
                Button(onClick = { noteViewModel.deleteNotes(note)
                    navigtor.pop()
                }) {
                    Text(text = "Delete Note")

                }

            }

        }
    }
}