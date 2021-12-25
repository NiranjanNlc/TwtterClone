package com.example.twtterclone.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.example.twtterclone.model.data.Tweet

@Dao
interface TweetDao
{
    @Insert(onConflict = REPLACE)
    fun save(tweet: Tweet)

    @Update
    fun update(tweet:Tweet)

    @Query("SELECT * FROM tweets ORDER BY creatTime ASC")
    fun getAlphabetizedWords(): LiveData<List<Tweet>>

}