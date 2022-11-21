package com.nathan.wswork.data.database

import androidx.room.Dao
import androidx.room.Insert
import com.nathan.wswork.data.model.User

@Dao
interface UserDao {

    @Insert
    fun insert(user: User)

}