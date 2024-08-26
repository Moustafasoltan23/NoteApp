package com.example.mynote.presentation.LoginScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
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

class WelcomeScreen :Screen {
    @Composable
    override fun Content() {
        val email = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        val navigtor = LocalNavigator.currentOrThrow
        val authViewModel = Autntictiion()
        val isError= remember { mutableStateOf(password.value) }

        Column(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
            verticalArrangement = Arrangement.Center ,
            horizontalAlignment = Alignment.CenterHorizontally) {
               Image(painter = painterResource(id = com.example.mynote.R.drawable.notes), contentDescription =null , modifier = Modifier.size(380.dp))
          Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Create a new Note Now " , modifier = Modifier.padding(16.dp) , fontSize = 25.sp , fontStyle = androidx.compose.ui.text.font.FontStyle.Italic)
            Text(text = "& Share with your Team "  , fontSize = 25.sp , fontStyle = androidx.compose.ui.text.font.FontStyle.Italic)



            Text(text = "Quick Caputure what's on your mind" , modifier = Modifier.padding(16.dp) , fontSize = 15.sp , fontStyle = androidx.compose.ui.text.font.FontStyle.Normal)
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = { navigtor.push(RegisterScreen()) } , modifier = Modifier
                .fillMaxWidth()
                ) {
                Text(text = "Create Account")
                
            }
            Spacer(modifier =Modifier.height(10.dp))

            Button(onClick = { navigtor.push(LoginScreen()) } , modifier = Modifier
                .fillMaxWidth()

                ) {
                Text(text = "Login")

            }





        }
    }
}