package com.example.twtterclone.viewModal

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.twtterclone.model.data.User
import com.example.twtterclone.model.repo.AuthenciationService
import kotlinx.coroutines.launch

class AuthenciationViewModel : ViewModel()
{
    var user = MutableLiveData<User>()
    var firebaseuser= AuthenciationService.userLiveData
    fun sighnUp()
    {
        Log.i("user ",user.toString())
        viewModelScope.launch {
            user.value?.let { AuthenciationService.sighnUpUser(it) }
        }
    }

    fun logOut() {
        viewModelScope.launch {
            AuthenciationService.logOut()
        }
    }

    fun sighIn() {
        viewModelScope.launch {
            user.value?.let { AuthenciationService.sighIn(it) }
        }
    }
}