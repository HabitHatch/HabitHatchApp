package com.habithatch.demo.core.app

import android.content.Context

import androidx.compose.ui.text.googlefonts.GoogleFont
import com.habithatch.demo.R
import com.habithatch.demo.data.db.AppDatabase
import com.habithatch.demo.data.db.DatabaseProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Configures Hilt DI providers for the app.
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): AppDatabase = DatabaseProvider.getDatabase(context)

    @Provides
    @Singleton
    fun provideGoogleFontProvider(): GoogleFont.Provider =
        GoogleFont.Provider(
            providerAuthority = "com.google.android.gms.fonts",
            providerPackage = "com.google.android.gms",
            certificates = R.array.com_google_android_gms_fonts_certs,
        )

    @Provides
    @Singleton
    fun provideUserDao(
        database: AppDatabase,
    ) = database.userDao()

    @Provides
    @Singleton
    fun provideGoalDao(
        database: AppDatabase,
    ) = database.goalDao()
}
