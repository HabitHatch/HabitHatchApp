package com.habithatch.demo.db

import android.content.Context
import androidx.room.Room
import androidx.room.Database
import androidx.room.RoomDatabase
import com.habithatch.demo.daos.GoalDao
import com.habithatch.demo.daos.PetDao
import com.habithatch.demo.daos.UserDao
import com.habithatch.demo.entities.Goal
import com.habithatch.demo.entities.Pet
import com.habithatch.demo.entities.User

@Database(entities = [User::class, Pet::class, Goal::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun petDao(): PetDao
    abstract fun goalDao(): GoalDao
}


object DatabaseProvider {
    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "app_database"
            ).fallbackToDestructiveMigration()
                .build()
            INSTANCE = instance
            instance
        }
    }
}