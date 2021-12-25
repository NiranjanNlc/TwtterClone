package com.example.twtterclone.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tweet
    (
    @PrimaryKey(autoGenerate= true)
     var statusid: String,
     var userId: String,
     var message: String,
     var retwtCount: String,
     var likeCount: String,
     var creatTime: Long
            )