package com.example.mvvm.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvm.data.source.local.dao.UserDao
import com.example.mvvm.domain.model.UserModel

@Database(entities = [UserModel::class], version = 1)
abstract class AppDatabase  : RoomDatabase(){
    abstract fun userDao(): UserDao

    companion object {
        const val DB_NAME = "MyDatabase.db"
    }
}