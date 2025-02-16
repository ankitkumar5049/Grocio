package com.example.grocio.utils

import android.content.Context
import androidx.room.Room
import com.example.grocio.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseBuilder {
    private var INSTANCE: UserDatabase? = null

    @Provides
    @Singleton
    fun getInstance(@ApplicationContext context: Context): UserDatabase {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                UserDatabase::class.java,
                "user_database"
            ).build()
        }
        return INSTANCE!!
    }

    @Provides
    fun provideUserDao(database: UserDatabase): UserDao {
        return database.userDao()
    }
}
