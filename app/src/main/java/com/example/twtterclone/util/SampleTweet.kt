package com.example.twtterclone.util

import com.example.twtterclone.model.data.Tweet
import java.util.*
import kotlin.collections.ArrayList

object SampleTweet
{
    fun getTweetList(): ArrayList<Tweet> {
        val tweetLisst = ArrayList<Tweet>()//Creating an empty arraylist
        tweetLisst.add(getTweet("Happy BirthDay "))
        tweetLisst.add(getTweet("Jaya Nepal "))
        tweetLisst.add(getTweet(" Lal Salam "))
        tweetLisst.add(getTweet(" I love you "))
        tweetLisst.add(getTweet(" Fuck Off "))
        tweetLisst.add(getTweet(" Who cares ?"))
        tweetLisst.add(getTweet(" Suta bhaii suta koi pattieney wala chaina "))
        return tweetLisst
    }

    fun getTweet(message: String) :Tweet
    {
         return Tweet(
             userId = (0 until 4352678239).random().toString(),
             message=message,
             retwtCount = 0,
             likeCount = 0,
             creatTime = Date(System.currentTimeMillis())
         )
    }
}