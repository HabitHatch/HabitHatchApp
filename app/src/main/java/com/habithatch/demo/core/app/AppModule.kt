package com.habithatch.demo.core.app

import android.content.Context

import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.core.config.HabitHatchDevConfig
import com.habithatch.demo.data.daos.GoalDao
import com.habithatch.demo.data.daos.UserDao
import com.habithatch.demo.data.db.AppDatabase
import com.habithatch.demo.data.db.DatabaseProvider
import com.habithatch.demo.data.mappers.GoalMapper
import com.habithatch.demo.data.repositories.GoalRepository
import com.habithatch.demo.data.repositories.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideConfig(): HabitHatchConfig = HabitHatchDevConfig

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): AppDatabase = DatabaseProvider.getDatabase(context)

    @Provides
    @Singleton
    fun provideGoalDao(database: AppDatabase): GoalDao = database.goalDao()

    @Provides
    @Singleton
    fun provideGoalMapper(config: HabitHatchConfig): GoalMapper = GoalMapper(config, config)

    @Provides
    @Singleton
    fun provideGoalRepository(
        goalDao: GoalDao,
        goalConfig: HabitHatchConfig,
        goalMapper: GoalMapper,
    ): GoalRepository =
        GoalRepository(
            goalDao = goalDao,
            statusesProvider = goalConfig,
            goalMapper = goalMapper,
        )

    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase): UserDao = database.userDao()

    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): UserRepository = UserRepository(userDao)
}
