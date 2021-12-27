package com.example.twtterclone.viewModal

import androidx.lifecycle.ViewModel
import com.example.twtterclone.model.data.Tweet
import com.example.twtterclone.model.repo.TweetRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TimeLineViewModal(private val repository: TweetRepo) : ViewModel()
{

    private val parentJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + parentJob)
    val tweets = repository.allTweets
    init
    {
    }

    fun updateRetweetCount(tweet: Tweet)
    {
        tweet.retwtCount=+1
        coroutineScope.launch {
            repository.update(tweet)
        }
    }
    fun updateLikeCount(tweet: Tweet)
    {
        tweet.likeCount=+1
        coroutineScope.launch {
            repository.update(tweet)
        }
    }
}