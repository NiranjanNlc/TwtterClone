package com.example.twtterclone.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tweet
    (
    @PrimaryKey(autoGenerate= true)
     val statusid: String,
     val userId: String,
     val message: String,
     val retwtCount: String,
     val likeCount: String,
     val creatTime: Long
            )