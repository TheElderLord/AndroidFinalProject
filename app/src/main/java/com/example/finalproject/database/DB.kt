package com.example.finalproject.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.finalproject.model.User
import com.example.finalproject.model.UserDao


@Database(entities = [User::class, Person::class], version = 1)
//creating database
abstract class DB:RoomDatabase() {
    abstract fun userDao():UserDao
    companion object{
        fun createDB(context: Context,DBname:String):DB{
            return Room.databaseBuilder(context,DB::class.java,DBname).build()

        }
    }

}