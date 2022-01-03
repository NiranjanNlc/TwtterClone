package com.example.twtterclone.viewModal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.twtterclone.model.data.Tweet
import com.example.twtterclone.model.repo.TweetRepo
import com.example.twtterclone.util.SampleTweet
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class TweetViewModal (private val repository: TweetRepo) : ViewModel(),CoroutineScope
{
    var tweetmessage = MutableLiveData<String>()
    init
    {

    }

    fun insertTweet()
    {
        val tweet = tweetmessage.value?.let { SampleTweet.getTweet(it) }
        println("tweets  $tweet ")
        this.launch{
            if (tweet != null) {
                repository.insert(tweet)
            }
        }
        tweetmessage.value = "nepal3e4"
    }
    override  val coroutineContext: CoroutineContext=Dispatchers.IO + SupervisorJob()
}