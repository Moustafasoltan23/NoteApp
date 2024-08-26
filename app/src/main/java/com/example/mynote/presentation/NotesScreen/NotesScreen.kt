package com.example.mynote.presentation.NotesScreen

import android.app.Application
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.mynote.presentation.NoteDetailsScreen.NoteDetailsScreen
import com.example.mynote.ui.noteViewModel
import kotlin.random.Random

@Composable
fun NotesScreenContent(noteViewModel: noteViewModel = hiltViewModel()) {
    val noteViewModel= noteViewModel(application = LocalContext.current.applicationContext as Application)
    val notes = noteViewModel.allNotes.collectAsState()

    val navigator = LocalNavigator.currentOrThrow
    LazyColumn {
        items(notes.value ?: emptyList(), key = { it.id }) { note ->
            // Generate a random color
            val randomColor = Color(
                red = Random.nextFloat(),
                green = Random.nextFloat(),
                blue = Random.nextFloat()

            )

            Card(
                elevation = CardDefaults.elevatedCardElevation(10.dp),
                modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        navigator.push(NoteDetailsScreen(note, ))
                    }
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = randomColor) // Set the random color
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row {
                        Text("")
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            modifier = Modifier.clickable {
                                noteViewModel.updateNotes(note.copy(isFavourite = !note.isFavourite))
                            },
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = if (note.isFavourite) Color.Yellow else Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = note.description)
                }
            }
        }
    }
}
