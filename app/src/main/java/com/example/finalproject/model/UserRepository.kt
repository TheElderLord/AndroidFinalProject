package com.example.finalproject.model

interface UserRepository {
//repository interface
   suspend fun insertUser(user: User)

    suspend fun getAll():List<User>
}