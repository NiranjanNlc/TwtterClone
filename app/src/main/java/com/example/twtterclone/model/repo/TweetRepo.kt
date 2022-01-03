package com.example.twtterclone.model.repo

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.twtterclone.model.dao.TweetDao
import com.example.twtterclone.model.data.Tweet
import com.example.twtterclone.model.data.User

class TweetRepo(private val tweetDao:TweetDao,) {

    val allTweets: LiveData<List<Tweet>> = tweetDao.getAlphabetizedTweets()
    val allUser: LiveData<List<User>> = tweetDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(tweet: Tweet) {
        println(" inserted the tweet  ")
        try {
            tweetDao.save(tweet)
        }
        catch (e:Exception)
        {
            println(" eroot to the saving twet "+ e.message)
        }
        println(" titter " + allTweets.getValue())
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(user: User) {
        println(" inserted the user ")
        tweetDao.saveUser(user)
        println(allUser.getValue())
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(tweet: Tweet)
    {
      tweetDao.update(tweet)
    }
}