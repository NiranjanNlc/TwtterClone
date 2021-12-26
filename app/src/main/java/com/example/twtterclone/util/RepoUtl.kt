package com.example.twtterclone.util

import android.content.Context
import com.example.twtterclone.model.db.TweetDb
import com.example.twtterclone.model.repo.TweetRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

object  RepoUtl
{
    fun getRepo (context: Context): TweetRepo {
        val applicationScope = CoroutineScope(SupervisorJob())
        val database =  TweetDb.getDatabase(context , applicationScope)
        return TweetRepo(database.tweetdDao(),)
        }

}