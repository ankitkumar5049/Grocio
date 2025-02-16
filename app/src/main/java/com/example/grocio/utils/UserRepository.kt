package com.example.grocio.utils

import com.example.grocio.dao.UserDao
import com.example.grocio.entity.User
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao) {
    suspend fun signUp(user: User): Long {
        return userDao.insertUser(user)
    }

    suspend fun login(email: String, password: String): User? {
        return userDao.getUser(email, password)
    }
}
