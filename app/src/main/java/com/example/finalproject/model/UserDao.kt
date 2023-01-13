package com.example.finalproject.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

//Access to data in database
@Dao
interface UserDao {
@Insert
suspend fun insertUser(user: User)

@Query("Select * from ${User.TABLE_NAME}")
suspend fun getAll():List<User>


}