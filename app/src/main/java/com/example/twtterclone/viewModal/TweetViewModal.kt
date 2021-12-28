package com.example.twtterclone.viewModal

import androidx.lifecycle.ViewModel
import com.example.twtterclone.model.data.Tweet
import com.example.twtterclone.model.repo.TweetRepo
import com.example.twtterclone.util.SampleTweet
import kotlinx.coroutines.*

class TweetViewModal (private val repository: TweetRepo) : ViewModel()
{
    var tweetmessage = String()
    private val parentJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + parentJob)
    init
    {

    }

    fun insertTweet()
    {
        val tweet = SampleTweet.getTweet(tweetmessage)
        runBlocking{
            repository.insert(tweet)
        }
        tweetmessage = ""
    }

}