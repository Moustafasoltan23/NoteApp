package com.example.mynote.presentation.LoginScreen

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.mylogin.ViewModel.Autntictiion
import com.example.mynote.R
import com.example.mynote.presentation.MainScreen.MainScreen
import com.example.mynote.ui.noteViewModel

class LoginScreen  : Screen{
    @Composable
    override fun Content() {
        val email = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        val navigtor = LocalNavigator.currentOrThrow
        val authViewModel = Autntictiion()
        val isError= remember { mutableStateOf(password.value) }
        val firstname = remember { mutableStateOf("") }
        val lastname = remember { mutableStateOf("") }

        //Ui of welcome Screen

        Column(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
            verticalArrangement = Arrangement.Center ,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.notelogin), contentDescription =null ,  modifier = Modifier.size(380.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Login", fontSize = 25.sp ,)
            Spacer(modifier = Modifier.height(10.dp))


            TextField(value = email.value, onValueChange ={email.value= it}, placeholder = { Text(text = "Email") } , modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight(align = Alignment.CenterVertically) , shape = RoundedCornerShape(24), leadingIcon = {
                Icon(Icons.Outlined.Person , contentDescription = "personal icons")
            })
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value = password.value, onValueChange ={password.value= it}, placeholder = { Text(text = "password") } , modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight(align = Alignment.CenterVertically) , shape = RoundedCornerShape(24), leadingIcon = {
                Icon(Icons.Outlined.Lock , contentDescription = "personal icons")
            })
            Spacer(modifier = Modifier.height(10.dp))

            //Button of Register to auth of firebase
            Button(onClick = { authViewModel.Login(email.value,password.value , onSuccess = {navigtor.push(MainScreen(
                noteViewModel(Application())
            )) } , onFailure = { }) }, modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth() ) {
                Text(text = "Login")

            }

            TextButton(onClick = {navigtor.push(RegisterScreen())}) {
                Text(text = "I dont have an account")

            }






        }
    }
}