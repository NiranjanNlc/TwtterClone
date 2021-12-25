package com.example.twtterclone.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.twtterclone.model.dao.TweetDao
import com.example.twtterclone.model.data.Tweet
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Database(entities = [Tweet::class], version = 1)
abstract class TweetDb : RoomDatabase() {
        abstract fun tweetdDao(): TweetDao
        private class TweetsDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    scope.launch {
                        var tweetDao = database.tweetdDao()
                        // Delete all content here.
                        //  tweetDao.deleteAll()
                        // Add sample tweets.
                        addTweets(tweetDao)

                    }
                }
            }
            private fun addTweets(tweetDao: TweetDao) {
//                var tweet = Tweets(name = "Hello")
//                tweetDao.save(tweet)
//                println(tweet.toString())
            }
        }
        companion object {
            // Singleton prevents multiple instances of database opening at the
            // same time.
            @Volatile
            private var INSTANCE: TweetDb? = null

            fun getDatabase(context: Context, scope: CoroutineScope): TweetDb {
                // if the INSTANCE is not null, then return it,
                // if it is, then create the database]
                println("You have acces over here ")
                return INSTANCE ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        TweetDb::class.java,
                        "tweet_database"
                    ).addCallback(TweetsDatabaseCallback(scope))
                        .build()
                    INSTANCE = instance
                    // return instance
                    instance
                }
            }


        }
    }
