package com.example.roomdatabase.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    val stdFirstName: String?=null,
    val stdLastName: String?=null,
    val stdUsername: String?=null,
    val stdPassword:String?=null
)
{
    @PrimaryKey(autoGenerate = true)
    var stdId:Int = 0
}