package com.example.twtterclone.model.data

import java.util.*

data class User
    (
    var userId : String,
    var noOfFollower: Int,
    var noOfFollowing :Int,
    var bio: String,
    var location: String,
    var creatTime: Date
            )