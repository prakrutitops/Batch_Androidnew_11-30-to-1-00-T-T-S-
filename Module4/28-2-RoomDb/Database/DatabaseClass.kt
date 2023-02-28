package com.example.roomdb.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdb.Dao.Daoclass
import com.example.roomdb.Entity.User

@Database(entities = [User::class], version = 1)
abstract class DatabaseClass : RoomDatabase()
{
    abstract fun daoClass(): Daoclass
}