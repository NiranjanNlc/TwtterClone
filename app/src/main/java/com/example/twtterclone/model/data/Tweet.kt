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
    val retwtCount: Int,
    val likeCount: Int,
    val creatTime: Date
            )