package com.example.finalproject.model

import android.annotation.SuppressLint
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomMasterTable.TABLE_NAME

//Structure of Users table
@SuppressLint("RestrictedApi")
@Entity(
     tableName = TABLE_NAME

)
data class User(
    //primary key
    @PrimaryKey
    val id:String,
    val name:String,
    val uname:String,
    val pass:String) {
    //static variables
    companion object{
        const val TABLE_NAME ="users"

        const val ID = "Id"
        const val NAME = "Name"
        const val USERNAME = "Username"
        const val PASSWORD = "Password"


    }
}