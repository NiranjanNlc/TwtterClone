package com.example.twtterclone.viewModal

import androidx.lifecycle.ViewModel
import com.example.twtterclone.model.repo.TweetRepo

class TimeLineViewModal(private val repository: TweetRepo) : ViewModel()
{

    val tweets = repository.allTweets
    init
    {
    }

}