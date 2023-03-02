package com.example.roomdb.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomdb.Entity.User

@Dao
interface Daoclass
{
    @Insert
    fun addUser(user: User?)

    @Query("select * from users")
    fun getUsers(): MutableList<User>

    @Update
    fun updateuser(user: User?)

    @Delete
    fun deleteuser(user: User?)
}