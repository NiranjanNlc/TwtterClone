package com.example.twtterclone.viewModal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.twtterclone.model.repo.TweetRepo
import com.google.android.gms.auth.api.Auth

class ViewModalFactory(private val repository: TweetRepo) : 
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        println(" Inn view odal factory")
        if (modelClass.isAssignableFrom(TimeLineViewModal::class.java)) {
            println("Assighnabke class")
            @Suppress("UNCHECKED_CAST")
            return TimeLineViewModal(repository) as T
        }
        else if  (modelClass.isAssignableFrom(TweetViewModal::class.java)) {
            println("Assighnabke class")
            @Suppress("UNCHECKED_CAST")
            return TweetViewModal(repository) as T
        }
        else if  (modelClass.isAssignableFrom(AuthenciationViewModel::class.java)) {
            println("Assighnabke class")
            @Suppress("UNCHECKED_CAST")
            return AuthenciationViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}