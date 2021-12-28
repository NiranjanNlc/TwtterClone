package com.example.twtterclone.viewModal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.twtterclone.model.data.Tweet
import com.example.twtterclone.model.repo.TweetRepo
import com.example.twtterclone.util.SampleTweet
import kotlinx.coroutines.*

class TweetViewModal (private val repository: TweetRepo) : ViewModel()
{
    var tweetmessage = MutableLiveData<String>()
    private val parentJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + parentJob)
    init
    {

    }

    fun insertTweet()
    {
        val tweet = tweetmessage.value?.let { SampleTweet.getTweet(it) }
        println("tweets  $tweet.toString()")
        coroutineScope.launch{
            if (tweet != null) {
                repository.insert(tweet)
            }
        }
        tweetmessage.value = "nepal3e4"
    }

}