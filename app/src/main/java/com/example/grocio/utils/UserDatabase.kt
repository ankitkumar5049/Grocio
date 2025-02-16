package com.example.grocio.utils

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.grocio.dao.UserDao
import com.example.grocio.entity.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
