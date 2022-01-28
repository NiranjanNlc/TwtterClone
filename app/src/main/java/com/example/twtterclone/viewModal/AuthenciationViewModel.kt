package com.example.twtterclone.viewModal

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.twtterclone.model.data.User
import com.example.twtterclone.model.repo.AuthRepo
import kotlinx.coroutines.launch

class AuthenciationViewModel : ViewModel()
{
    var user = MutableLiveData<User>()
    var firebaseuser= AuthRepo.userLiveData
    fun sighnUp()
    {
        Log.i("user ",user.toString())
        viewModelScope.launch {
            user.value?.let { AuthRepo.sighnUpUser(it) }
        }
    }

    fun logOut() {
        viewModelScope.launch {
            AuthRepo.logOut()
        }
    }

    fun sighIn() {
        viewModelScope.launch {
            user.value?.let { AuthRepo.sighIn(it) }
        }
    }
}