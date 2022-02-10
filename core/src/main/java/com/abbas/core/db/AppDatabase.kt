package com.abbas.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abbas.core.BuildConfig
import com.abbas.core.user.data.local.UserDao
import com.abbas.core.user.data.local.UserEntity

@Database(
    entities = [
        UserEntity::class
    ], version = 1
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

}
