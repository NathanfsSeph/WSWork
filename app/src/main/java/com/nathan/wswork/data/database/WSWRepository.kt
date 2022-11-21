package com.nathan.wswork.data.database

import com.nathan.wswork.data.model.User

interface WSWRepository {
    suspend fun insertUser(user: User)
}