package com.nathan.wswork.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nathan.wswork.data.model.Lead
import com.nathan.wswork.data.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Query("SELECT * FROM User WHERE email = :email AND password = :password")
    fun get(email: String, password: String): User
}