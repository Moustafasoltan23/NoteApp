package com.example.mynote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import com.example.mynote.presentation.LoginScreen.WelcomeScreen
import com.example.mynote.presentation.LoginScreen.RegisterScreen
import com.example.mynote.presentation.MainScreen.MainScreen
import com.example.mynote.ui.noteViewModel
import com.example.mynote.ui.theme.MyNoteTheme


class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    //viewmodel1.insertNotes(Note(id = 5 , title = "My Phone Notes" , description = "phone num 01009604974 " , isFavourite = true))

        setContent {
          val noteViewModel = noteViewModel(application)
           // val noteViewModel : noteViewModel = hiltViewModel()
          //  val noteViewMoel :noteViewModel by viewModels()
            Navigator(screen = WelcomeScreen(),)





        }
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyNoteTheme {
        Greeting("Android")
    }
}

@Composable
fun AddNotesDilog(onAddNote:(String , String)->Unit , onDismissRequesrt :()->Unit){
    val title = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    AlertDialog(onDismissRequest = { onDismissRequesrt() }, confirmButton = {
        Button(enabled = title.value.isNotEmpty() && description.value.isNotEmpty()
            ,onClick = { onAddNote(title.value , description.value) }) {
            Text(text = "Add Note")

        }
    }, title = { Text(text = "Add Note")} , text = {
        Column {
            OutlinedTextField( placeholder = { Text(text = "Add title")},value = title.value, onValueChange ={title.value= it} )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(placeholder = { Text(text = "Add Decription")},value = description.value, onValueChange = {description.value= it})
        }
    })
}