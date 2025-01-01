package com.habithatch.demo.core.app

import com.habithatch.demo.core.config.GoalPriorityProvider
import com.habithatch.demo.core.config.GoalStatusProvider
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.core.config.HabitHatchDevConfig
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Configures Hilt DI bindings for the app.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class AppBindingModule {
    @Binds
    @Singleton
    abstract fun bindConfig(devConfig: HabitHatchDevConfig): HabitHatchConfig

    @Binds
    @Singleton
    abstract fun bindPrioritiesProvider(devConfig: HabitHatchDevConfig): GoalPriorityProvider

    @Binds
    @Singleton
    abstract fun bindStatusProvider(devConfig: HabitHatchDevConfig): GoalStatusProvider
}
