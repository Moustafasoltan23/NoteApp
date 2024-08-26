package com.example.mylogin.ViewModel

import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class Autntictiion :ViewModel() {
    val firebaseauth= FirebaseAuth.getInstance()
    private var auth = Firebase.auth
    private lateinit var googleSignInClient: GoogleSignInClient





    fun  Login(email:String,password:String , onSuccess : ()->Unit , onFailure : (String)->Unit) {
        try {
            firebaseauth.signInWithEmailAndPassword(email, password).addOnCompleteListener() {
                if (it.isSuccessful) {

                    //register --> navigte to ;ogin screen
                    onSuccess()

                }else{
                    onFailure(it.exception?.message?:"Unknown erorr")
                }
            }.addOnFailureListener {exception ->
                onFailure(exception.message?:"UnKnown erorr")
            }

        } catch (e: Exception) {
            onFailure(e.message?:"UnKnown erorr")

        }


    }
    fun  Regitser(email:String,password:String , onSuccess : ()->Unit , onFailure : (String)->Unit) {
        try {
            firebaseauth.createUserWithEmailAndPassword(email, password).addOnCompleteListener() {
                if (it.isSuccessful) {

                    //register --> navigte to register screen
                    onSuccess()

                }else{
                    onFailure(it.exception?.message?:"UnKnown erorr ")
                }
            }.addOnFailureListener {exception ->
                onFailure(exception.message?:"UnKnown erorr")
            }

        } catch (e: Exception) {
            onFailure(e.message?:"UnKnown erorr")

        }


    }



}