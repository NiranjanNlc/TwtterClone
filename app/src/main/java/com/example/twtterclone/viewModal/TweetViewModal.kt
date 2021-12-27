package com.example.twtterclone.viewModal

import androidx.lifecycle.ViewModel
import com.example.twtterclone.model.data.Tweet
import com.example.twtterclone.model.repo.TweetRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TweetViewModal (private val repository: TweetRepo) : ViewModel()
{
    private val parentJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + parentJob)
    init
    {

    }

    fun insertTweet(tweet: Tweet)
    {
        coroutineScope.launch {
            repository.insert(tweet)
        }
    }

}