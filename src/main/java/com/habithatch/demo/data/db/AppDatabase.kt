package com.habithatch.demo.data.db

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.habithatch.demo.data.daos.GoalDao
import com.habithatch.demo.data.daos.UserDao
import com.habithatch.demo.data.entities.GoalEntity
import com.habithatch.demo.data.entities.UserEntity

/**
 * The Room database for this app.
 */
@Database(entities = [UserEntity::class, GoalEntity::class], version = 17)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    abstract fun goalDao(): GoalDao
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
