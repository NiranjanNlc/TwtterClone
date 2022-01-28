package com.example.twtterclone.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class User
    (
    @PrimaryKey(autoGenerate = true)
    var userId : Long,
    var name: String?=null,
    var userName : String?=null,
    var password: String?=null,
    var noOfFollower: Int?=null,
    var noOfFollowing :Int?=null,
    var bio: String?=null,
    var location: String?=null,
    var creatTime: Date?=null
            )