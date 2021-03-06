package com.example.twtterclone.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Tweet(
    @PrimaryKey(autoGenerate= true)
    val statusid: Long=0,
    val userId: String,
    val message: String,
    var retwtCount: Int,
    var likeCount: Int,
    val creatTime: Date
            )