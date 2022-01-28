package com.example.twtterclone.model.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.twtterclone.model.data.User
import com.example.twtterclone.util.FirebaseUtils
import com.example.twtterclone.util.FirebaseUtils.database
import com.example.twtterclone.util.FirebaseUtils.firebaseAuth
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await

object AuthRepo {

    private lateinit  var result : AuthResult
    val userLiveData: MutableLiveData<FirebaseUser>
    val loggedOutLiveData: MutableLiveData<Boolean>

    fun logOut() {
        firebaseAuth.signOut()
        loggedOutLiveData.postValue(true)
    }

    suspend fun sighnUpUser(user: User)
    {
        try {
            result =  FirebaseUtils.firebaseAuth.
            createUserWithEmailAndPassword(user.userName, user.password).await()
        }
        catch (e:Exception)
        {
            Log.i("SghnUpErro",e.message.toString())
        }
        if(result.user !=null)
        {
            writeUserToDataBAse(user)
        }
    }

    private suspend fun writeUserToDataBAse(user: User) {
        try{
            val data =  firebaseAuth.uid?.let { database.child("users").child(it).setValue(user) }
                ?.await()
            println(" dta base result $data.toString()")
            userLiveData.postValue(firebaseAuth.currentUser)
        }catch (e : Exception){
            println(" Sghnng up excepto ${e.message}")
        }
    }

    suspend fun sighIn(user: User)
    {
      firebaseAuth.signInWithEmailAndPassword(user.userName,user.password).await()
        userLiveData.postValue(firebaseAuth.currentUser)
        loggedOutLiveData.postValue(false)
    }

    init {
        userLiveData = MutableLiveData()
        loggedOutLiveData = MutableLiveData()
        if (firebaseAuth.currentUser != null) {
            loggedOutLiveData.postValue(false)
        }
    }
}