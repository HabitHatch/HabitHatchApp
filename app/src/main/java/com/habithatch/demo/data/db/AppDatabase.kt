package com.habithatch.demo.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.habithatch.demo.data.daos.GoalDao
import com.habithatch.demo.data.daos.UserDao
import com.habithatch.demo.data.entities.Goal
import com.habithatch.demo.data.entities.User

@Database(entities = [User::class, Goal::class], version = 7)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun goalDao(): GoalDao
}


object DatabaseProvider {
    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room
                .databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app_database"
                )
                .fallbackToDestructiveMigration()
                .build()
            INSTANCE = instance
            instance
        }
    }
}