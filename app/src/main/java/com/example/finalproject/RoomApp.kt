package com.example.finalproject

import android.app.Application
import com.example.finalproject.database.DB
import com.example.finalproject.model.UserRepImpl
import com.example.finalproject.model.UserRepository


//application that holds Room
class RoomApp:Application() {
    private lateinit var database:DB
    lateinit var repository: UserRepository
    override fun onCreate() {
        super.onCreate()
        //initialize database
        database=DB.createDB(applicationContext, db_name)
        repository=UserRepImpl(database.userDao())

    }
    companion object{
        private const val db_name = "App"

    }
}