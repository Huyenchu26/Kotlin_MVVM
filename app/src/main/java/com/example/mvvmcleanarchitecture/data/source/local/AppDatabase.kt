package com.example.mvvmcleanarchitecture.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmcleanarchitecture.data.source.local.dao.UserDao
import com.example.mvvmcleanarchitecture.domain.model.UserModel

@Database(entities = [UserModel::class], version = 1)
abstract class AppDatabase  : RoomDatabase(){
    abstract fun userDao(): UserDao

    companion object {
        const val DB_NAME = "MyDatabase.db"
    }
}