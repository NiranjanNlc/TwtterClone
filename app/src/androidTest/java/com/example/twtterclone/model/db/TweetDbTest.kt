package com.example.twtterclone.model.db

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import com.example.twtterclone.model.dao.TweetDao
import com.example.twtterclone.util.SampleTweet
import junit.framework.TestCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class TweetDbTest : TestCase()
{
    private lateinit var tweetDao: TweetDao
    private lateinit var db: TweetDb

    @Before
    override fun setUp()
    {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val applicationScope = CoroutineScope(SupervisorJob())
        db = TweetDb.getDatabase(context,applicationScope)
        tweetDao = db.tweetdDao()
    }
    override fun tearDown() {
        super.tearDown()
        db.close()
    }
    @Test
    fun writeAndReadTweet() = runBlocking {
        val tweet = SampleTweet.getTweet(" Hello Nepal ")
        tweetDao.save(tweet)
        val test = tweetDao.getAlphabetizedTweets().value?.contains(tweet)
        assert(test == true)
    }
    @Test
    fun writeAndReadUser() = runBlocking {
//        val spend = Spend(Date(), 100, "for Bread")
//        spendsDao.addSpend(spend)
//        val spends = spendsDao.getLast20Spends()
//        assertThat(spends.contains(spend)).isTrue()
    }
}