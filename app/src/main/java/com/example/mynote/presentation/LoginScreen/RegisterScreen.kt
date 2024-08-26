package com.example.mynote.presentation.LoginScreen

import android.app.Application
import android.graphics.drawable.Icon
import android.provider.ContactsContract.CommonDataKinds.Note
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
import androidx.compose.material3.OutlinedTextField
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
import cafe.adriel.voyager.core.R
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.mylogin.ViewModel.Autntictiion
import com.example.mynote.presentation.MainScreen.MainScreen
import com.example.mynote.ui.noteViewModel

class RegisterScreen : Screen {
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
          Image(painter = painterResource(id = com.example.mynote.R.drawable.notelogin), contentDescription =null ,  modifier = Modifier.size(240.dp))
           Spacer(modifier = Modifier.height(10.dp))
           Text(text = "Register Now", fontSize = 25.sp ,)
           Spacer(modifier = Modifier.height(10.dp))
           TextField(value = firstname.value, onValueChange ={firstname.value= it}, placeholder = { Text(text = "first name")} , modifier = Modifier
               .padding(16.dp)
               .fillMaxWidth()
               .wrapContentHeight(align = Alignment.CenterVertically) , shape = RoundedCornerShape(24),
           )
           TextField(value = lastname.value, onValueChange ={lastname.value= it}, placeholder = { Text(text = "Last name")} , modifier = Modifier
               .padding(16.dp)
               .fillMaxWidth()
               .wrapContentHeight(align = Alignment.CenterVertically) , shape = RoundedCornerShape(24),)
           TextField(value = email.value, onValueChange ={email.value= it}, placeholder = { Text(text = "Email")} , modifier = Modifier
               .padding(16.dp)
               .fillMaxWidth()
               .wrapContentHeight(align = Alignment.CenterVertically) , shape = RoundedCornerShape(24), leadingIcon = {
               Icon(Icons.Outlined.Person , contentDescription = "personal icons")
           })

           TextField(value = password.value, onValueChange ={password.value= it}, placeholder = { Text(text = "password")}, supportingText = { Text(
               text = "password must be at least 6 characters",
           )} , modifier = Modifier
               .padding(16.dp)
               .fillMaxWidth()
               .wrapContentHeight(align = Alignment.CenterVertically) , shape = RoundedCornerShape(24), leadingIcon = {
               Icon(Icons.Outlined.Lock , contentDescription = "personal icons")
           })


           //Button of Register to auth of firebase
           Button(onClick = { authViewModel.Regitser(email.value,password.value , onSuccess = { navigtor.push(LoginScreen())} , onFailure = {exception -> isError.value = exception }) }, modifier = Modifier
               .padding(16.dp)
               .fillMaxWidth() ) {
               Text(text = "Regitser")

           }


           TextButton(onClick = {navigtor.push(LoginScreen())}) {
               Text(text = "Already have an account")

           }


          



       }
    }
}