package com.example.finalproject.model

class UserRepImpl(val userDao: UserDao):UserRepository {

    //implementation of UserRepositoryInterface
    override suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    override suspend fun getAll():List<User> {
    return userDao.getAll()
    }

}