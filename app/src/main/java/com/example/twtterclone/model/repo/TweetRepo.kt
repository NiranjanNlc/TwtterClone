package com.example.twtterclone.model.repo

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.twtterclone.model.dao.TweetDao
import com.example.twtterclone.model.data.Tweet

class TweetRepo(private val tweetDao:TweetDao,) {

    val allTweets: LiveData<List<Tweet>> = tweetDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(tweet: Tweet) {
        println(" inserted the tweet  ")
        tweetDao.save(tweet)
        println(allTweets.getValue())
    }
}