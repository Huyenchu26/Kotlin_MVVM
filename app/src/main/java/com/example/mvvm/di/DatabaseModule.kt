package com.example.mvvm.di

import dagger.Provides
import androidx.room.Room
import android.app.Application
import com.example.mvvm.data.source.local.AppDatabase
import com.example.mvvm.data.source.local.dao.UserDao
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    internal fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            AppDatabase.DB_NAME
        ).allowMainThreadQueries().build()
    }


    @Provides
    internal fun providePhotoDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }
}