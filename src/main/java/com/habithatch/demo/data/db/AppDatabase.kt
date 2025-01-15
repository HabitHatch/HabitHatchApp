package com.habithatch.demo.data.db

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.habithatch.demo.data.daos.HabitDao
import com.habithatch.demo.data.daos.UserDao
import com.habithatch.demo.data.entities.HabitEntity
import com.habithatch.demo.data.entities.User

/**
 * The Room database for this app.
 */
@Database(entities = [User::class, HabitEntity::class], version = 18)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    abstract fun habitDao(): HabitDao
}

/**
 * @suppress
 */
object DatabaseProvider {
    @Volatile
    private var instance: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase =
        instance ?: synchronized(this) {
            val instance =
                Room
                    .databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app_database",
                    ).fallbackToDestructiveMigration()
                    .build()
            this@DatabaseProvider.instance = instance
            instance
        }
}
