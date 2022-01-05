package com.example.twtterclone.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class User
    (
    @PrimaryKey(autoGenerate = true)
    var userId : Long,
    var name: String,
    var userName : String,
    var password: String,
    var noOfFollower: Int,
    var noOfFollowing :Int,
    var bio: String,
    var location: String,
    var creatTime: Date
            )