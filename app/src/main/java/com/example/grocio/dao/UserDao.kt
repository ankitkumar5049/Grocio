package com.example.grocio.dao

import androidx.room.*
import com.example.grocio.entity.User
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertUser(user: User): Long  // Returns user ID after successful insertion

    @Query("SELECT * FROM user_table WHERE email = :email AND password = :password")
    suspend fun getUser(email: String, password: String): User?
}
