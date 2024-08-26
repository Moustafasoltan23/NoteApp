package com.example.mynote.presentation.MainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.example.mynote.AddNotesDilog
import com.example.mynote.presentation.FavouriteScreen.FavouriteScreencontent
import com.example.mynote.presentation.NotesScreen.NotesScreenContent
import com.example.mynote.Data.Db.Note
import com.example.mynote.ui.noteViewModel
import com.example.mynote.ui.theme.MyNoteTheme

class MainScreen( val noteViewModel: noteViewModel) :Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        // val noteViewModel : noteViewModel = hiltViewModel()

        val  selectedIndex = remember { mutableStateOf(0) }
        val showDilog = remember { mutableStateOf(false) }

        MyNoteTheme {
            // A surface container using the 'background' color from the theme

            Scaffold (topBar = { TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription =null , tint = Color.White)

                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription =null , tint = Color.White)

                }
                }

                ,colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black), title = { Text(text = "My Notes" , color = Color.White) }) },
                floatingActionButton =  { IconButton( modifier = Modifier.size(60.dp),colors = IconButtonDefaults.iconButtonColors(containerColor = Color.Black),
                    onClick = { showDilog.value= true }) {
                    Icon(  modifier = Modifier.size(35.dp), imageVector = Icons.Default.Add, contentDescription =null , tint = Color.White)

                }
                },
                bottomBar = {
                    BottomAppBar (containerColor = Color.Black){
                        IconButton(modifier = Modifier
                            .weight(1f)
                            .size(35.dp),onClick = { selectedIndex.value= 0}) {
                            Icon(modifier = Modifier.size(35.dp),imageVector = Icons.Default.Home, contentDescription =null , tint =if (selectedIndex.value==0) Color.White else Color.Gray )

                        }
                        IconButton(modifier = Modifier
                            .weight(1f)
                            .size(35.dp) , onClick = { selectedIndex.value=1}) {
                            Icon(modifier = Modifier.size(35.dp) ,imageVector = Icons.Default.Favorite, contentDescription =null , tint = if (selectedIndex.value==1) Color.Red else Color.Gray  )

                        }


                    }
                }

            ){
                Column(modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(Color.Black)) {
                    if (showDilog.value){
                        AddNotesDilog(onAddNote = {title , description -> noteViewModel.insertNotes(
                            Note( id = 0, title = title , description = description , isFavourite = false)
                        )
                            showDilog.value = false
                        } , onDismissRequesrt = {showDilog.value= false})
                    }
                    if (selectedIndex.value==0){
                        NotesScreenContent( noteViewModel)
                    }else{
                        FavouriteScreencontent()
                    }


                }
            }



        }
    }
}