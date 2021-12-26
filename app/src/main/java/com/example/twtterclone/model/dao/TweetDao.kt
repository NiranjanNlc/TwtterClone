package com.example.twtterclone.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.example.twtterclone.model.data.Tweet
import com.example.twtterclone.model.data.User

@Dao
interface TweetDao
{
    @Insert(onConflict = REPLACE)
    fun save(tweet: Tweet)

    @Update
    fun update(tweet:Tweet)

    @Query("SELECT * FROM tweet ORDER BY creatTime ASC")
    fun getAlphabetizedTweets(): LiveData<List<Tweet>>

    @Insert(onConflict = REPLACE)
    fun save(user: User)

    @Update
    fun update(user: User)

    @Query("SELECT * FROM user ORDER BY creatTime ASC")
    fun getAlphabetizedWords(): LiveData<List<User>>

}